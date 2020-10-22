/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import entity.Account;
import entity.Product;
import entity.User;
import javamarket.App;
import tools.managers.ProductManager;
import tools.managers.UserManager;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */
public class UIMethods {
    //exit programm
    public static String exit(){
        Print.alert("Выйти из программы? y/n"," ");
        String exit = Scan.getString().toLowerCase();
        return exit;
    }
    
    //add product
    public static void addProduct(){
        try{
            Product product = new Product();
            String product_name = Scan.getString("Введите название продукта: ");
            product.setName(product_name);
            double product_price = Scan.getDouble("Введите стоимоть продукта: ");
            product.setPrice(product_price);
            int product_quantity = Scan.getInt("Введите количество: ");
            product.setQuantity(product_quantity);
            boolean successAddProduct = ProductManager.add(product);
            if(successAddProduct){
                System.out.println(product.toString() + " добавлен");
            }
            else{
                Print.errorln("Не удалось добавить продукт");
            }
        }catch(RuntimeException e){
            System.out.println();
            Print.errorln("Не удалось добавить продукт");
        }
    }
    
    //delete product
    public static void deleteProduct(){
        if(ProductManager.getProducts().size() > 0){
            try{
                int product_index = Scan.getIndex(ProductManager.getProducts(), 1, "Выберите продукт для удаления: ");
                Product productToDelete = (Product)ProductManager.getProducts().get(product_index-1);
                if(ProductManager.delete(productToDelete)){
                    System.out.println(productToDelete.toString() + " удален");
                }
                else{
                    Print.errorln("Не удалось удалить продукт", " "+productToDelete.toString());
                }
            }catch(NumberFormatException e){
                Print.errorln("Неверный индекс");
            }
        }
    }
    
    //log in
    public static User login(){
        String login;
        String password;
        User user = UserManager.getGuest();
            
        Print.alert("Имя пользователя:", " ");
        login = Scan.getString();
        Print.alert("Пароль:", " ");
        password = Scan.getString();
        for(User u : UserManager.getUsers()){
            if(u.getLogin().equals(login)){
                if(u.getPassword().equals(password)){
                    user = u;
                }
                break;
            }
        }
        return user;
    }
    
    //registeration
    public static void registration(){
        String login;
        String password;
        String confirmPassword;
        User user = null;
            
        //get user name
        Print.alert("Введите имя пользователя:", " ");
        login = Scan.getString();
        for(User u : UserManager.getUsers()){
            if(u.getLogin().equals(login)){
                Print.errorln("Пользователь с таким именем уже зарегистрирован");
                return;
            }
        }
        
        //get password
        Print.alert("Введите пароль:", " ");
        password = Scan.getString();
        if(password.length() == 0 || password.split(" ").equals("") || password.equals("")){
            Print.errorln("Недопустимый пароль");
            return;
        }
        
        //confirm password
        Print.alert("Подтвердите пароль:", " ");
        confirmPassword = Scan.getString();
        if(!password.equals(confirmPassword)){
            Print.errorln("Пароли не совпадают");
            return;
        }
        
        //success registration
        user = new User(login, password, App.Role.USER);
        UserManager.add(user);
        System.out.println("Пользователь зарегистрирован");
    }

    static void buyProduct(User user) {
        if(ProductManager.getProducts().size() > 0){
            try{
                Print.printList(ProductManager.getProducts());
                int product_index = Scan.getIndex(ProductManager.getProducts(), 1, "Выберите продукт: ");
                Product product = (Product)ProductManager.getProducts().get(product_index-1);
                
                //check deal is valid
                if(user.getAccount().getMoney() < product.getCost()){
                    Print.errorln("Недостаточно средств");
                    return;
                }
                if(product.getQuantity() <= 0){
                    Print.alertln("Продукта нет в наличии");
                    return;
                }
                
                user.getAccount().setMoney(user.getAccount().getMoney() - product.getCost());
                product.setQuantity(product.getQuantity()-1);
                System.out.println("Вы успешно купили продукт: "+product.toString());
                    
            }catch(NumberFormatException e){
                Print.errorln("Неверный индекс");
            }
        }else{
            Print.emptyMessage();
        }
    }
    
}
