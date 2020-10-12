/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Print;

/**
 *
 * @author pupil
 */
public class Product {
    
    //variables
    private int id;
    private String name;
    private double price;
    private int quantity;
    //constructors
    public Product(String name, double price, int quantity){
        this.id = this.hashCode();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    //toString
    @Override
    public String toString() {
        return "Product{" + 
                "id=" + id + 
                ", name=" + name + 
                ", cost=" + price + 
                '}';
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
    public void setName(String name) {
        this.name = name;
    }
    //return true if value above zero, else return false
    public boolean setCost(double cost) {
        try{
            if(cost < 0) throw new NumberFormatException();
            this.price = cost;
            return true;
        }catch(NumberFormatException e){
            Print.error("Нельзя установить стоимость продукта меньше нуля\nУстановлена стоимость 1");
            this.price = 1;
            return false;
        }
    }
    //return true if value above zero, else return false
    public boolean setQuantity(int quantity){
        try{
            if(quantity < 0) throw new NumberFormatException();
            this.quantity = quantity;
            return true;
        }catch(NumberFormatException e){
            Print.error("Нельзя установить количество продукта меньше нуля");
            return false;
        }
    }
    
}
