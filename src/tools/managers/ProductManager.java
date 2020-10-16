/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Product;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;

/**
 *
 * @author pupil
 */
public class ProductManager extends App{
    
    //get products
    public static ArrayList<Product> getProducts(){
        return products;
    }
    
    //add customer to ArrayList and save to file
    public static boolean add(Product product){
        products.add(product);
        return save();
    }
    
    //delete customer from ArrayList
    public static boolean delete(Product product){
        products.remove(product);
        return save();
    }
    //delete customer from ArrayList with id
    public static boolean delete(int id){
        Product customer = null;
        for(Product p : products){
            if(p.getId() == id){
                customer = p;
                break;
            }
        }
        products.remove(customer);
        return save();
    }
    
    public static boolean increaseQuantity(Product product, int count){
        boolean setQuantity = product.setQuantity(product.getQuantity()+count);
        if(!setQuantity) return setQuantity;
        return save();
    }
    
    public static boolean decreaseQuantity(Product product, int count){
        boolean out = product.setQuantity(product.getQuantity()-count);
        save();
        return out;
    }
    
    //load customers ArrayList from file
    public static void load(){
        products = FileManager.loadFromFile(App.DIRECTORY_PATH+App.PRODUCTS_FILE_PATH);
        if(products == null){
            products = new ArrayList();
        }
    }
    
    //save customers ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(products, App.DIRECTORY_PATH+App.PRODUCTS_FILE_PATH);
    }
}

