/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class Scan {
    
    //scanner
    public static Scanner scanner = new Scanner(System.in);
    
    public static int getInt(String str){
        System.out.println(str);
        String iStr = scanner.nextLine();
        int i = Integer.parseInt(iStr);
    }
}
