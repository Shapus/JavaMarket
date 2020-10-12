/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Customer;
import javamarket.App;
import tools.files.FileManager;
import static javamarket.App.customers;

/**
 *
 * @author pupil
 */
public class CustomerManager {
    
    //add customer to ArrayList and save to file
    public static void add(Customer customer){
        customers.add(customer);
        save();
    }
    
    //delete customer from ArrayList
    public static void delete(Customer customer){
        customers.remove(customer);
        save();
    }
    //delete customer from ArrayList with id
    public static void delete(int id){
        Customer customer = null;
        for(Customer c : customers){
            if(c.getId() == id){
                customer = c;
                break;
            }
        }
        customers.remove(customer);
        save();
    }
    
    //load customers ArrayList from file
    public static void load(){
        customers = FileManager.loadFromFile(App.DIRECTORY_PATH+App.CUSTOMERS_FILE_PATH);
    }
    
    //save customers ArrayList to file
    public static void save(){
        FileManager.saveToFile(customers, App.DIRECTORY_PATH+App.CUSTOMERS_FILE_PATH);
    }
}
