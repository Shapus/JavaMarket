/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Customer;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;

/**
 *
 * @author pupil
 */
public class CustomerManager extends App{
    
    //get customers
    public static ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    //add customer to ArrayList and save to file
    public static boolean add(Customer customer){
        customers.add(customer);
        return save();
    }
    
    //delete customer from ArrayList
    public static boolean delete(Customer customer){
        customers.remove(customer);
        return save();
    }
    //delete customer from ArrayList with id
    public static boolean delete(int id){
        Customer customer = null;
        for(Customer c : customers){
            if(c.getId() == id){
                customer = c;
                break;
            }
        }
        customers.remove(customer);
        return save();
    }
    
    //load customers ArrayList from file
    public static void load(){
        customers = FileManager.loadFromFile(App.DIRECTORY_PATH+App.CUSTOMERS_FILE_PATH);
    }
    
    //save customers ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(customers, App.DIRECTORY_PATH+App.CUSTOMERS_FILE_PATH);
    }
}
