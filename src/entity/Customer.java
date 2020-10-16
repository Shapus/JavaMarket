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
public final class Customer extends User implements Serializable{
    
    //variables
    
    private String name;
    private double money;
    private boolean registered = false;
    
    //constructors
    public Customer(String name){
        super();
        this.setName(name);
        this.setMoney(money);
    }
    public Customer(Customer customer){
        super();
        this.setName(customer.getName());
        this.setMoney(customer.getMoney());
    }
    public Customer(String login, String password, String name){
        super(login, password, App.Role.USER);
        this.setName(name);
        this.setMoney(money);
    }
    public Customer(String login, String password, Customer customer){
        super(login, password, App.Role.USER);
        this.setName(customer.getName());
        this.setMoney(customer.getMoney());
    }
    
    //toString
    @Override
    public String toString() {
        if(isRegistered()){
            return "Customer("+App.BLUE+"ЗАРЕГИСТРИРОВАН"+App.RESET+")" + 
                    "id = " + App.BLUE + id + App.RESET + ", " +
                    "login = " + App.BLUE + login + App.RESET + ", " +
                    "name = " + App.BLUE + name + App.RESET + ", " +
                    "money = " + App.BLUE + money + App.RESET;
        }
        else{
            return "Customer("+App.RED+"НЕ ЗАРЕГИСТРИРОВАН"+App.RESET+")" + 
                    "id = " + App.BLUE + id + App.RESET + ", " +
                    "login = НЕТ ИМЕНИ ПОЛЬЗОВАТЕЛЯ" + ", " +
                    "name = " + App.BLUE + name + App.RESET + ", " +
                    "money = " + App.BLUE + money + App.RESET;
        }
    }
    
    //getters
    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    public boolean isRegistered() {
        return registered;
    }
    
    //setters
    public void setName(String name) {
        try{
            if(name.isEmpty() || name.split(" ").length == 0 || name.split(" ").equals("")) throw new RuntimeException();
            this.name = name;
        }catch(RuntimeException e){
            Print.errorln("Пустое название продукта");
        }
    }
    //return true if value above zero, else return false
    public boolean setMoney(double money) {
        try{
            if(money < 0) throw new NumberFormatException();
            this.money = money;
            return true;
        }catch(NumberFormatException e){
            Print.errorln("Нельзя установить количество денег меньше нуля\nУстановлено зачение: 0");
            this.money = 0;
            return false;
        }
    }
    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
