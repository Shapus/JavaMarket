/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javamarket.App.Role;

/**
 *
 * @author pupil
 */
public class User implements Serializable{
    
    //variables
    private int id;
    private String login;
    private String password;
    private Role role;
    private long account;
    private ArrayList<Product> products = new ArrayList();
    
    //constructors
    public User(Role role){
        this.id = this.hashCode();
        this.role = role;
    }
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
    public long getAccount() {
        return account;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    
    //setters
    public final void setLogin(String login) {
        this.login = login;
    }
    public final void setPassword(String password) {
        this.password = password;
    }
    public void setAccount(long account){
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.login);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.role);
        hash = 89 * hash + Objects.hashCode(this.account);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        return true;
    }
    
}
