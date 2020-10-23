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
import utils.Print;

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
        return saveNLoad();
    }
    
    //delete customer from ArrayList
    public static boolean delete(Product product){
        products.remove(product);
        return saveNLoad();
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
        return saveNLoad();
    }
    
    public static boolean increaseQuantity(Product product, int count){
        try{
            product.setQuantity(product.getQuantity()+count);
            return saveNLoad();
        }catch(RuntimeException e){
            Print.errorln("Не удалось увеличить количество");
            return false;
        }
    }
    
    public static boolean decreaseQuantity(Product product, int count){
        try{
            product.setQuantity(product.getQuantity()-count);
            return saveNLoad();
        }catch(RuntimeException e){
            Print.errorln("Не удалось изменить количество");
            return false;
        }
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
    public static boolean saveNLoad(){
        boolean out;
        out = save();
        load();
        return out;
    }
}

