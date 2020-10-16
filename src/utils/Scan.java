/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Scanner;
import static javamarket.App.taskList;

/**
 *
 * @author pupil
 */
public class Scan{
    
    //scanner
    public static Scanner scanner = new Scanner(System.in);
    
    //get integer
    public static int getInt(String str){
        try{
            System.out.print(str);
            String iStr = scanner.nextLine();
            int i = Integer.parseInt(iStr);
            return i;
        }catch(NumberFormatException e){
            Print.errorln("Неверный ввод");
        }
        return 0;
    }
    public static int getInt(){
        try{
            String iStr = scanner.nextLine();
            int i = Integer.parseInt(iStr);
            return i;
        }catch(NumberFormatException e){
            Print.errorln("Неверный ввод");
        }
        return 0;
    }
    
    
    //get string
    public static String getString(String str){
        System.out.print(str);
        String outStr = scanner.nextLine();
        return outStr;
    }
    public static String getString(){
        String outStr = scanner.nextLine();
        return outStr;
    }
    
    //get double
    public static double getDouble(String str){
        try{
            System.out.print(str);
            String iStr = scanner.nextLine();
            double d = Double.parseDouble(iStr);
            return d;
        }catch(NumberFormatException e){
            Print.errorln("Неверный ввод");
        }
        return 0;
    }
    public static double getDouble(){
        try{
            String iStr = scanner.nextLine();
            double d = Double.parseDouble(iStr);
            return d;
        }catch(NumberFormatException e){
            Print.errorln("Неверный ввод");
        }
        return 0;
    }
    
    //get ArrayList/String[] index. If index above array size or less zero, throw NumberFormatException
    //Should rewrite with generics
    public static int getIndex(ArrayList list, int shift, String str){
        int index = getInt(str);
        if(index > list.size()-1+shift || index < shift) throw new NumberFormatException();
        return index;
    }
    public static int getIndex(String[] list, int shift, String str){
        int index = getInt(str);
        if(index > list.length-1+shift || index < shift) throw new NumberFormatException();
        return index;
    }
    
    //choose operation from task list
    public static int getOperation(String[] list){
        boolean gotOperation = false;
        int operation = -1;
        try{
            operation = Scan.getIndex(list, 0, "Введите номер операции: ");
        }catch(NumberFormatException e){
            Print.errorln("Операция введена неверно");
            operation = -1;
        }
        return operation;
    }
}
