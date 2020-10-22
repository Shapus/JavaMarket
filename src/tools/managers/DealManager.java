/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Deal;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;

/**
 *
 * @author pupil
 */
public class DealManager extends App{
        
    //get deals
    public static ArrayList getDeals(){
        return deals;
    }
    
    //add customer to ArrayList and save to file
    public static boolean add(Deal deal){
        deals.add(deal);
        return saveNLoad();
    }
    
    //load customers ArrayList from file
    public static void load(){
        deals = FileManager.loadFromFile(App.DIRECTORY_PATH+App.DEALS_FILE_PATH);
        if(deals == null){
            deals = new ArrayList();
        }
    }
    
    //save customers ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(deals, App.DIRECTORY_PATH+App.DEALS_FILE_PATH);
    }
    public static ArrayList getLastDeal(){
        ArrayList<Deal> lastDeal = new ArrayList();
        if(deals.size() > 0){
            lastDeal.add(deals.get(deals.size()-1));
        }
        return lastDeal;
    }
    public static ArrayList getLastDeals(int count){
        ArrayList<Deal> lastDeals = new ArrayList();
        if(deals.size() > count){
            for(int i=deals.size()-count;i<deals.size();i++){
                lastDeals.add(deals.get(i));
            }
        }
        else{
            for(Deal d : deals){
                lastDeals.add(d);
            }
        }
        return lastDeals;
    }
    private static boolean saveNLoad(){
        boolean out;
        out = save();
        load();
        return out;
    }

}
