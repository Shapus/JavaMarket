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
public class Customer implements Serializable{
    
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
        return "Customer " + App.BLUE + id + App.RESET + ", " +
                "name = " + App.BLUE + name + App.RESET + ", " +
                "money = " + App.BLUE + money + App.RESET;
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
