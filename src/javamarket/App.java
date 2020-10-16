/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamarket;

import entity.Customer;
import entity.Deal;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import tools.files.FileManager;
import userinterface.API;
import tools.managers.CustomerManager;
import tools.managers.DealManager;
import tools.managers.ProductManager;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */
public class App {
    
    //user roles
    public static enum Role{GUEST, USER, ADMIN};
    
    //file paths
    public static String DIRECTORY_PATH = "data\\";
    public static String CUSTOMERS_FILE_PATH = "customers.txt";
    public static String PRODUCTS_FILE_PATH = "products.txt";
    public static String DEALS_FILE_PATH = "deals.txt";
    public static String USERS_FILE_PATH = "users.txt";
    
    //console colors
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    
    
    //market data
    protected static ArrayList<Customer> customers;
    protected static ArrayList<Product> products;
    protected static ArrayList<Deal> deals;
    protected static ArrayList<User> users;
    public static String[] taskList = {
                        "Выйти из программы",
                        "Добавить продукт",
                        "Добавить покупателя",
                        "Список продуктов",
                        "Список покупателей",
                        "Удалить продукт",
                        "Удалить покупателя",
                        "Продать",
                        "Посмотреть последнюю запись",
                        "Посмотреть последние n записей",
                        "Посмотреть все записи"
                        };
    private int operation;
    private String exit;
    
    
    public void run(){
        FileManager.loadAll();
        exit = "n";
        System.out.println("------ МАГАЗИН ------");
        while(exit.equals("n")){
            Print.printList(taskList);
            operation = Scan.getOperation(taskList);
            if(operation != -1){
                Print.alertln(taskList[operation]);
            }
            switch (operation) {
                case 0:                
                    exit = API.exit();
                    break;
                case 1:     
                    API.addProduct();
                    break;
                case 2:   
                    API.addCustomer();
                    break;
                case 3:   
                    Print.printList(products);
                    break;
                case 4:    
                    Print.printList(customers);
                    break;
                case 5:   
                    Print.printList(products);
                    API.deleteProduct();
                    break;
                case 6:    
                    Print.printList(customers);
                    API.deleteCustomer();
                    break;
                default:
                    Print.errorln("Нет такой операции");
            }
            System.out.print("\n\n");
        }
        FileManager.saveAll();
    }
}
