/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import static java.lang.Integer.max;
import java.util.ArrayList;
import javamarket.App;
/**
 *
 * @author pupil
 */
public class Print {
    
    //print menu with borders
    public static void printList(ArrayList list){
        
        //if list is empty
        if(list.isEmpty()){
            emptyMessage();
            return;
        }
        
        //get strings for printing (split object.toString() with ",")
        String[] strs = getStrs(list);
        int len = getLen(strs);
        
        //print strings 
        for (int i=0;i<strs.length;i++) {
            printLine(len);
            System.out.printf("| %"+-len+"d. |\n", i+1);
            for(int j=0;j<strs.length;j++){
                System.out.printf("| %"+-len+"s |\n", strs[i]);
            } 
            printLine(len);
        }
    }
    //print menu with borders
    public static void printList(String[] list){
        
        //if list is empty
        if(list.length == 0){
            emptyMessage();
            return;
        }
        
        //get strings for printing (split object.toString() with ",")
        int len = getLen(list);
        
        //print strings 
        printLine(len);
        for (int i=0;i<list.length;i++) {
            String str = String.format("| %d. %s ", i, list[i]);
            System.out.printf(String.format("%"+-len+"s",str));
            System.out.println("|");
        }
        printLine(len);
    }
    
    //if no data message
    public static void emptyMessage(){       
        printLine();
        System.out.println("|"+App.BLUE+"               НЕТ ДАННЫХ             "+App.RESET+"|");
        printLine();
    }
    
    
    
    //message with red bg
    public static void error(String str){
        System.out.println(App.RED_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET);
    }
    public static void error(String str, String after){
        System.out.println(App.RED_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET + " " + after);
    }
    
    //message with blue bg
    public static void alert(String str){
        System.out.println(App.BLUE_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET);
    }
    public static void alert(String str, String after){
        System.out.println(App.BLUE_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET + " " + after);
    }
    
    public static void printLine(int count){
        for(int i=0;i<count;i++){
           System.out.print("-"); 
        }System.out.println("");
    }
    public static void printLine(){
        for(int i=0;i<40;i++){
           System.out.print("-"); 
        }System.out.println("");
    }
    public static int getLen(String[] strs){
        int len = 0;
        String str;
        for (int i=0;i<strs.length;i++) {
            str = String.format("| %d. %s |\n", i, strs[i]);
            len = max(len, str.length());    
        }
        return len;
    }
    public static String[] getStrs(ArrayList list){
        String[] items = new String[list.size()];
        for(int i=0;i<list.size();i++){
            items[i] = list.get(i).toString();
        }
        return items;
    }
}
