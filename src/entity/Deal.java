/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javamarket.App;
import tools.managers.AccountManager;

/**
 *
 * @author pupil
 */
public class Deal implements Serializable {
    
    public enum Operation{
        SELL("sell"), BUY("buy");
        private String data;
        Operation(String str){
            data = str;
        }
        public String get(){
            return data;
        }
    };
    
    //variables
    private final int id;
    private final Date date;
    private final long account;
    private final User user;
    private final Product product;
    private final int quantity;
    private final Operation operation;
    
    //costructors
    public Deal(User user, Product product, Operation operation){
        this.id = this.hashCode();
        this.date = new Date();
        this.user = user;
        this.account = user.getAccount();
        this.product = product;
        this.quantity = 1;
        this.operation = operation;
    }
    public Deal(User user, Product product, int quantity, Operation operation){
        this.id = this.hashCode();
        this.date = new Date();
        this.user = user;
        this.account = user.getAccount();
        this.product = product;
        this.quantity = quantity;
        this.operation = operation;
    }    

    //toString
    @Override
    public String toString() {
        return "Deal " + App.BLUE + id + App.RESET + ":\n" +
                "   date = " + App.BLUE + date + App.RESET + "\n" +
                "   user = " + App.BLUE + user + App.RESET + "\n" +
                "   account = " + App.BLUE + AccountManager.getAccount(account) + App.RESET + "\n" +
                "   operation = " + App.BLUE_BACKGROUND +App.WHITE + " " + operation.get() + " " + App.RESET + "\n" +
                "   product = " + App.BLUE + product + App.RESET + "\n" +
                "   quantity = " + App.BLUE + quantity + App.RESET;
    }
    
    //getters
    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public long getCustomer() {
        return account;
    }
    public Product getProduct() {
        return product;
    }
    
}
