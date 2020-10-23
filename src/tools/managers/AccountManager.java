/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Account;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;

/**
 *
 * @author pupil
 */
public class AccountManager extends App{
    
    //get accounts
    public static ArrayList<Account> getAccounts(){
        return accounts;
    }
    
    //delete account from ArrayList with id
    public static Account getAccount(long id){
        Account account = null;
        for(Account c : accounts){
            if(c.hashCode() == id){
                account = c;
                break;
            }
        }
        return account;
    }
    
    //add account to ArrayList and save to file
    public static boolean add(Account account){
        accounts.add(account);
        return saveNLoad();
    }
    
    //delete account from ArrayList
    public static boolean delete(Account account){
        accounts.remove(account);
        return saveNLoad();
    }
    //delete account from ArrayList with id
    public static boolean delete(int id){
        Account account = null;
        for(Account c : accounts){
            if(c.hashCode() == id){
                account = c;
                break;
            }
        }
        accounts.remove(account);
        return saveNLoad();
    }
    public static long newAccount(){
        Account account = new Account(1000d);
        add(account);
        return accounts.get(accounts.size()-1).getId();
    }
    //give money to account
    public static boolean giveMoney(Account account, double money) throws RuntimeException{
        boolean out;
        if(money <= 0){
            throw new RuntimeException();
        }
        account.setMoney(account.getMoney() + money);
        return saveNLoad();
    }
    
    //load accounts ArrayList from file
    public static void load(){
        accounts = FileManager.loadFromFile(App.DIRECTORY_PATH+App.ACCOUNTS_FILE_PATH);
    }
    
    //save accounts ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(accounts, App.DIRECTORY_PATH+App.ACCOUNTS_FILE_PATH);
    }
    public static boolean saveNLoad(){
        boolean out;
        out = save();
        load();
        return out;
    }
}
