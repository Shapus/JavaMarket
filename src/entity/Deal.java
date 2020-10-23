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

/**
 *
 * @author pupil
 */
public class Deal implements Serializable {
    
    //variables
    private final int id;
    private final Date date;
    private final Account customer;
    private final Product product;
    private final int quantity;
    
    //costructors
    public Deal(int id, int date, Account customer, Product product){
        this.id = this.hashCode();
        this.date = new Date();
        this.customer = customer;
        this.product = product;
        this.quantity = 1;
    }
    public Deal(int id, int date, Account customer, Product product, int quantity){
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
    public Account getCustomer() {
        return customer;
    }
    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.customer);
        hash = 97 * hash + Objects.hashCode(this.product);
        hash = 97 * hash + this.quantity;
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
        final Deal other = (Deal) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
}
