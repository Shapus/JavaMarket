/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javamarket.App;
import utils.Print;

/**
 *
 * @author pupil
 */
public final class Product implements Serializable {
    
    //variables
    private int id;
    private String name;
    private double price;
    private int quantity;
    
    //constructors
    public Product(){
        this.id = this.hashCode();
    };
    public Product(String name, double price, int quantity) throws RuntimeException{
        this.id = this.hashCode();
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
    }
    
    //toString
    @Override
    public String toString() {
        return  "Product " + App.BLUE + id + App.RESET + ": { " +     
                "name = " + App.BLUE + name + App.RESET + ", " +
                "cost = " + App.BLUE + price + App.RESET + ", " +
                "quantity = " + App.BLUE + quantity + App.RESET + " }";
    }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCost() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    
    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        if(name.isEmpty() || name.split(" ").length == 0 || name.split(" ").equals("")){
            Print.errorln("Неверное имя продукта");
            throw new RuntimeException();
        }
        this.name = name;
    }
    //return true if value above zero, else return false
    public void setPrice(double cost){
        if(cost <= 0){
            Print.errorln("Неверная цена");
            throw new RuntimeException();
        }
        this.price = cost;
    }
    //return true if value above zero, else return false
    public void setQuantity(int quantity){
        if(quantity < 0){
            Print.errorln("Неверное количество");
            throw new RuntimeException();
        }
        this.quantity = quantity;
    }
    
}
