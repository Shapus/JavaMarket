/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Account;
import entity.Deal;
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
        Product userProduct = new Product(product.getName(), product.getCost(), 1);
        for(Product p : user.getProducts()){
            if(p.getId() == product.getId()){
                p.setQuantity(p.getQuantity()+1);
                return AccountManager.saveNLoad() && UserManager.saveNLoad() && ProductManager.saveNLoad();
            }
        }
        DealManager.getDeals().add(new Deal(user, product, Deal.Operation.BUY));
        user.getProducts().add(userProduct);
        return FileManager.saveAll();
    }
    
    //sell product
    public static boolean sell(User user, int product_index){
        Account account = AccountManager.getAccount(user.getAccount());
        Product product = user.getProducts().get(product_index);
        if(product.getQuantity() <= 0){
            Print.errorln("Продукта нет в наличии");
            return false;
        }
        account.setMoney(account.getMoney() + product.getCost());
        user.getProducts().get(product_index).setQuantity(product.getQuantity()-1);
        if(user.getProducts().get(product_index).getQuantity() <= 0){
            user.getProducts().remove(product_index);
        };
        DealManager.getDeals().add(new Deal(user, product, Deal.Operation.SELL));
        return FileManager.saveAll();
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
        users = FileManager.loadFromFile(Path.DIRECTORY.get() + Path.USERS.get());
    }
    
    //save users ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(users, Path.DIRECTORY.get() + Path.USERS.get());
    }
    
    public static boolean saveNLoad(){
        boolean out;
        out = save();
        load();
        return out;
    }
}
