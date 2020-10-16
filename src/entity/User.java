/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javamarket.App.Role;

/**
 *
 * @author pupil
 */
public class User implements Serializable{
    
    //variables
    protected int id;
    protected String login;
    protected String password;
    protected Role role;
    
    //constructors
    public User(){
        this.id = this.hashCode();
        this.role = Role.USER;
    };
    public User(String login, String password, Role role){
        this.id = this.hashCode();
        this.setLogin(login);
        this.setPassword(password);
        this.role = role;
    }
    
    //to string
    @Override
    public String toString() {
        return "User{" + "login=" + login + ", role=" + role + '}';
    }

    
    
    //getters
    public int getId(){
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
    
    //setters
    public final void setLogin(String login) {
        this.login = login;
    }
    public final void setPassword(String password) {
        this.password = password;
    }
    
}
