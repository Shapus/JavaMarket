/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamarket;

import API.APIInterface;
import entity.Account;
import entity.Deal;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import tools.files.FileManager;
import security.Security;

/**
 *
 * @author pupil
 */
public class App {
    
    //security class
    Security security;
    User user;
    
    //user roles
    public static enum Role{GUEST, USER, ADMIN};
    
    //file paths
    public static String DIRECTORY_PATH = "data\\";
    public static String ACCOUNTS_FILE_PATH = "accounts.txt";
    public static String PRODUCTS_FILE_PATH = "products.txt";
    public static String DEALS_FILE_PATH = "deals.txt";
    public static String USERS_FILE_PATH = "users.txt";
    
    //console colors
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    
    
    //market data
    protected static ArrayList<Account> accounts;
    protected static ArrayList<Product> products;
    protected static ArrayList<Deal> deals;
    protected static ArrayList<User> users;
    
    
    public static String[] taskList;
    private int operation;
    private String exit;
    
    
    public void run(){
        FileManager.loadAll();
        //init security system
        security = new Security();
        user = security.run();
        if(user == null){
            
        }
        else if(user.getRole() == Role.USER){
            System.out.println("user");
            APIInterface.userInterface(user);
        }
        else if(user.getRole() == Role.ADMIN){
            System.out.println("admin");
            APIInterface.adminInterface(user);
        }
        FileManager.saveAll();
    }
}
