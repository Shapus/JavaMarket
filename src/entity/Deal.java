/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author pupil
 */
public class Deal {
    
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
        return "Deal{" + 
                "id=" + id + 
                ", date=" + date + 
                ", customer=" + customer + 
                ", product=" + product + 
                ", quantity=" + quantity + 
                '}';
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
