/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Product;
import javamarket.App;
import tools.files.FileManager;
import static javamarket.App.customers;
import static javamarket.App.products;

/**
 *
 * @author pupil
 */
public class ProductManager {
    //add customer to ArrayList and save to file
    public static void add(Product product){
        products.add(product);
        save();
    }
    
    //delete customer from ArrayList
    public static void delete(Product product){
        products.remove(product);
        save();
    }
    //delete customer from ArrayList with id
    public static void delete(int id){
        Product customer = null;
        for(Product p : products){
            if(p.getId() == id){
                customer = p;
                break;
            }
        }
        products.remove(customer);
        save();
    }
    
    public static void increaseQuantity(Product product, int count){
        product.setQuantity(product.getQuantity()+count);
        save();
    }
    
    public static boolean decreaseQuantity(Product product, int count){
        boolean out = product.setQuantity(product.getQuantity()-count);
        save();
        return out;
    }
    
    //load customers ArrayList from file
    public static void load(){
        customers = FileManager.loadFromFile(App.DIRECTORY_PATH+App.PRODUCTS_FILE_PATH);
    }
    
    //save customers ArrayList to file
    public static void save(){
        FileManager.saveToFile(customers, App.DIRECTORY_PATH+App.PRODUCTS_FILE_PATH);
    }
}

