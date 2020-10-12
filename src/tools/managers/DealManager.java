/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Deal;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;
import static javamarket.App.deals;

/**
 *
 * @author pupil
 */
public class DealManager {
        
    //add customer to ArrayList and save to file
    public static void add(Deal deal){
        deals.add(deal);
        save();
    }
    
    //load customers ArrayList from file
    public static void load(){
        deals = FileManager.loadFromFile(App.DIRECTORY_PATH+App.DEALS_FILE_PATH);
        if(deals == null){
            deals = new ArrayList();
        }
    }
    
    //save customers ArrayList to file
    public static void save(){
        FileManager.saveToFile(deals, App.DIRECTORY_PATH+App.DEALS_FILE_PATH);
    }
}
