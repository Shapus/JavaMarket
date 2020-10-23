/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Account;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;
import utils.Print;

/**
 *
 * @author pupil
 */
public class UserManager extends App{
    private static User guest = new User(Role.GUEST);
    //get products
    public static ArrayList<User> getUsers(){
        return users;
    }
    
    //add user to ArrayList and save to file
    public static boolean add(User user){
        users.add(user);
        return saveNLoad();
    }
    
    //get guest
    public static User getGuest(){
        return guest;
    }
    
    //buy product
    public static boolean buy(User user, Product product){
        Account account = AccountManager.getAccount(user.getAccount());
        //check deal is valid
        if(account.getMoney() < product.getCost()){
            Print.errorln("Недостаточно средств");
            return false;
        }
        if(product.getQuantity() <= 0){
            Print.errorln("Продукта нет в наличии");
            return false;
        }
        account.setMoney(account.getMoney() - product.getCost());
        product.setQuantity(product.getQuantity()-1);
        for(Product p : user.getProducts()){
            if(p.getId() == product.getId()){
                p.setQuantity(p.getQuantity()+1);
                return AccountManager.saveNLoad() && UserManager.saveNLoad() && ProductManager.saveNLoad();
            }
        }
        user.getProducts().add(product);
        return AccountManager.saveNLoad() && UserManager.saveNLoad() && ProductManager.saveNLoad();
    }
    
    //sell product
    public static boolean sell(User user, Product product){
        Account account = AccountManager.getAccount(user.getAccount());

        if(user.getProducts().contains(product)){
            account.setMoney(account.getMoney() + product.getCost());
            for(Product p : user.getProducts()){
                if(p.getId() == product.getId()){
                    p.setQuantity(p.getQuantity()-1);
                    if(p.getQuantity() == 0){
                        user.getProducts().remove(p);
                    }
                    return AccountManager.saveNLoad() && UserManager.saveNLoad() && ProductManager.saveNLoad();
                }
            }
        }
        return AccountManager.saveNLoad() && UserManager.saveNLoad() && ProductManager.saveNLoad();
    }
    
    //add user to ArrayList and save to file
    public static boolean addAdmin(){
        User user = new User(App.Role.ADMIN);
        user.setLogin("admin");
        user.setPassword("admin");
        users.add(user);
        return saveNLoad();
    }
    //add user to ArrayList and save to file
    public static boolean addBank(){
        User user = new User(App.Role.BANK);
        user.setLogin("bank");
        user.setPassword("bank");
        users.add(user);
        return saveNLoad();
    }
    
    
    //delete user from ArrayList
    public static boolean delete(User user){
        users.remove(user);
        return saveNLoad();
    }
    //delete user from ArrayList with id
    public static boolean delete(int id){
        User user = null;
        for(User u : users){
            if(u.getId() == id){
                user = u;
                break;
            }
        }
        users.remove(user);
        return saveNLoad();
    }
    
    //load users ArrayList from file
    public static void load(){
        users = FileManager.loadFromFile(App.DIRECTORY_PATH+App.USERS_FILE_PATH);
    }
    
    //save users ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(users, App.DIRECTORY_PATH+App.USERS_FILE_PATH);
    }
    
    public static boolean saveNLoad(){
        boolean out;
        out = save();
        load();
        return out;
    }
}
