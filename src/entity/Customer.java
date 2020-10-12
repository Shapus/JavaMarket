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
public class Customer {
    
    //variables
    private int id;
    private String name;
    private double money;
    
    //constructors
    public Customer(String name){
        this.id = this.hashCode();
        this.name = name;
        this.money = 1000;
    }
    public Customer(Customer customer){
        this.id = customer.id;
        this.name = customer.name;
        this.money = customer.money;
    }
    
    //toString
    @Override
    public String toString() {
        return "Customer{" + 
                "id=" + id + 
                ", name=" + name + 
                ", money=" + money + 
                '}';
    }
    
    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    
    //setters
    public void setName(String name) {
        this.name = name;
    }
    //return true if value above zero, else return false
    public boolean setMoney(float money) {
        try{
            if(money < 0) throw new NumberFormatException();
            this.money = money;
            return true;
        }catch(NumberFormatException e){
            Print.error("Нельзя установить количество денег меньше нуля\nУстановлено зачение: 0");
            this.money = 0;
            return false;
        }
    }
}
