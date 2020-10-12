/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.files;

import utils.Print;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author pupil
 */
public class FileManager {
    
    //save arrayList to file
    public static void saveToFile(ArrayList list, String path){
        FileOutputStream fileOut = null;
        ObjectOutputStream objectOut = null;
        try {
            fileOut = new FileOutputStream(path);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(list);
            objectOut.flush();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            Print.error("Ошибка ввода/вывода:", ex.toString());
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Print.error("Ошибка закрытия файла:", ex.toString());
            }
        }
    }
    
    //load arrayList from file
    public static ArrayList loadFromFile(String path){
        ArrayList out = new ArrayList();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            fileIn = new FileInputStream(path);
            objectIn = new ObjectInputStream(fileIn);
            out = (ArrayList) objectIn.readObject();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            Print.error("Ошибка ввода/вывода:", ex.toString());
        } catch (ClassNotFoundException ex) {
            Print.error("Ошибка чтения файла:", ex.toString());
        }finally{
            return out;
        }
    }
}
