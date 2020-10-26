/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Random;
import javamarket.App;
import utils.Print;

/**
 *
 * @author pupil
 */
public class Account implements Serializable{
    
    //variables
    long id = System.currentTimeMillis()/new Random().nextInt(10000);
    protected double money;
    
    //constructors
    public Account(Double money){
        this.setMoney(money);
    }
    
    //toString
    @Override
    public String toString() {
        return "Account{" + 
                "id = " + App.BLUE + getId() + App.RESET + ", " +
                "money = " + App.BLUE + money + App.RESET + "}";
    }
    
    //getters
    public double getMoney() {
        return money;
    }
    public long getId(){
        return id;
    }
    
    //return true if value above zero, else return false
    public final boolean setMoney(double money) {
        try{
            if(money < 0) throw new NumberFormatException();
            this.money = money;
            return true;
        }catch(NumberFormatException e){
            Print.errorln("Нельзя установить количество денег меньше нуля");
            return false;
        }
    }
    
}
