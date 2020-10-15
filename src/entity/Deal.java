/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javamarket.App;

/**
 *
 * @author pupil
 */
public class Deal implements Serializable {
    
    //variables
    private int id;
    private Date date;
    private Customer customer;
    private Product product;
    private int quantity;
    
    //costructors
    public Deal(int id, int date, Customer customer, Product product){
        this.id = this.hashCode();
        this.date = new Date();
        this.customer = customer;
        this.product = product;
        this.quantity = 1;
    }
    public Deal(int id, int date, Customer customer, Product product, int quantity){
        this.id = this.hashCode();
        this.date = new Date();
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }    

    //toString
    @Override
    public String toString() {
        return "Deal " + App.BLUE + id + App.RESET + ":\n" +
                "   date = " + App.BLUE + date + App.RESET + "\n" +
                "   customer = " + App.BLUE + customer + App.RESET + "\n" +
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
    public Customer getCustomer() {
        return customer;
    }
    public Product getProduct() {
        return product;
    }
    
}
