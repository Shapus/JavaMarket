/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamarket;

import UI.Interface;
import entity.Account;
import entity.Deal;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import tools.files.FileManager;
import security.Security;
import tools.managers.AccountManager;
import tools.managers.UserManager;
import utils.Print;

/**
 *
 * @author pupil
 */
public class App {
    
    //security class
    Security security;
    User user;
    
    //user roles
    public static enum Role{GUEST, USER, ADMIN, BANK};
    
    //file paths
    public static enum Path{
        DIRECTORY("data\\"), ACCOUNTS("accounts.txt"), PRODUCTS("products.txt"), DEALS("deals.txt"), USERS("users.txt");
        String path;
        Path(String str){
            path = str;
        }
        public String get(){
            return path;
        }
    };
    
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
    private boolean runApp;

    public void run(){
        FileManager.loadAll();
        boolean existAdmin = false;
        boolean existBank = false;
        boolean existUser = false;
        int i = 0;
        while(!existAdmin && !existBank && !existUser && i<users.size()){
            user = users.get(i);
            i++;
            if(user.getRole() == Role.ADMIN){
                existAdmin = true;
            }
            if(user.getRole() == Role.BANK){
                existBank = true;
            }
            if(user.getRole() == Role.USER){
                existUser = true;
            }
        }
        if(!existAdmin){
            UserManager.addAdmin();
        }
        if(!existBank){
            UserManager.addBank();
        }
        if(!existUser){
            User newUser = new User("user", "user", Role.USER);
            newUser.setAccount(AccountManager.newAccount());
            AccountManager.getAccount(newUser.getAccount()).setMoney(1000000000);
            UserManager.add(newUser);
        }
        //init security system
        
        runApp = true;
        while(runApp){
            security = new Security();
            user = security.run();
            if(user == null){
                runApp = false;
            }
            else if(user.getRole() == Role.GUEST){
                
            }
            else if(user.getRole() == Role.BANK){
                runApp = Interface.bankInterface(user);
            }
            else if(user.getRole() == Role.USER){
                runApp = Interface.userInterface(user);
            }
            else if(user.getRole() == Role.ADMIN){
                runApp = Interface.adminInterface(user);
            }
        }
        FileManager.saveAll();
    }
}
