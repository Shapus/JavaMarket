/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import entity.Customer;
import entity.Product;
import entity.User;
import javamarket.App;
import tools.managers.CustomerManager;
import tools.managers.ProductManager;
import tools.managers.UserManager;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */
public class API {
    //exit programm
    public static String exit(){
        Print.alert("Выйти из программы? y/n"," ");
        String exit = Scan.getString().toLowerCase();
        return exit;
    }
    
    //add product
    public static void addProduct(){
        String product_name = Scan.getString("Введите название продукта: ");
        double product_price = Scan.getDouble("Введите стоимоть продукта: ");
        int product_quantity = Scan.getInt("Введите количество: ");
        Product product = new Product(product_name, product_price, product_quantity);
        boolean successAddProduct = ProductManager.add(product);
        if(successAddProduct){
            System.out.println(product.toString() + " добавлен");
        }
        else{
            Print.errorln("Не удалось добавить продукт", " "+product.toString());
        }
    }
    
    //add customer
    public static void addCustomer(){
        String customer_name = Scan.getString("Введите имя покупателя: ");
        Customer customer = new Customer(customer_name);
        boolean successAddCustomer = CustomerManager.add(customer);
        if(successAddCustomer){
            System.out.println(customer.toString() + " добавлен");
        }
        else{
            Print.errorln("Не удалось зарегистрировать покупателя", " "+customer.toString());
        }
    }
    
    //delete product
    public static void deleteProduct(){
        if(ProductManager.getProducts().size() > 0){
            try{
                int product_index = Scan.getIndex(ProductManager.getProducts(), 1, "Выберите продукт для удаления: ");
                Product productToDelete = ProductManager.getProducts().get(product_index-1);
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
    
    //delete customer
    public static void deleteCustomer(){
        if(CustomerManager.getCustomers().size() > 0){
            try{
                int customer_index = Scan.getIndex(CustomerManager.getCustomers(), 1, "Выберите покупателя для удаления: ");
                Customer customerToDelete = CustomerManager.getCustomers().get(customer_index-1);
                if(CustomerManager.delete(customerToDelete)){
                    System.out.println(customerToDelete.toString() + " удален");
                }
                else{
                    Print.errorln("Не удалось удалить пользователя", " "+customerToDelete.toString());
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
        User user = null;
            
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
    public static void registeration(){
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
        System.out.println(user.toString() + " зарегистрирован");
    }
}
