/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.User;
import java.util.ArrayList;
import javamarket.App;
import tools.files.FileManager;

/**
 *
 * @author pupil
 */
public class UserManager extends App{
    
    //get products
    public static ArrayList<User> getUsers(){
        return users;
    }
    
    //add user to ArrayList and save to file
    public static boolean add(User user){
        users.add(user);
        return save();
    }
    
    //delete user from ArrayList
    public static boolean delete(User user){
        users.remove(user);
        return save();
    }
    //delete user from ArrayList with id
    public static boolean delete(int id){
        User user = null;
        for(User u : users){
            if(u.getId() == id){
                user = u;
                break;
            }
        }
        users.remove(user);
        return save();
    }
    
    //load users ArrayList from file
    public static void load(){
        users = FileManager.loadFromFile(App.DIRECTORY_PATH+App.USERS_FILE_PATH);
    }
    
    //save users ArrayList to file
    public static boolean save(){
        return FileManager.saveToFile(users, App.DIRECTORY_PATH+App.USERS_FILE_PATH);
    }
}
