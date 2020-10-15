/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamarket;

import entity.Customer;
import entity.Deal;
import entity.Product;
import java.util.ArrayList;
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
    
    //file paths
    public static String DIRECTORY_PATH = "data\\";
    public static String CUSTOMERS_FILE_PATH = "customers.txt";
    public static String PRODUCTS_FILE_PATH = "products.txt";
    public static String DEALS_FILE_PATH = "deals.txt";
    
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
    
    
    
    public static ArrayList<Customer> customers;
    public static ArrayList<Product> products;
    public static ArrayList<Deal> deals;
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
    private int operation = 0;
    public void run(){
        ProductManager.load();
        CustomerManager.load();
        DealManager.load();
                String exit = "n";
        System.out.println("------ МАГАЗИН ------");
        while(exit.equals("n")){
            Print.printList(taskList);
            if(getOperation()){
                System.out.println(BLUE_BACKGROUND + " " + WHITE + taskList[operation] + " " + RESET);
            }

            switch (operation) {
                case 0:                
                    Print.alert("Выйти из программы? y/n");
                    exit = Scan.getString().toLowerCase();
                    break;
                case 1:     
                    String product_name = Scan.getString("Введите название продукта: ");
                    double product_price = Scan.getDouble("Введите стоимоть продукта: ");
                    int product_quantity = Scan.getInt("Введите количество: ");
                    Product product = new Product(product_name, product_price, product_quantity);
                    boolean successAddProduct = ProductManager.add(product);
                    if(successAddProduct){
                        System.out.println("Продукт " + product.toString() + " добавлен");
                    }
                    else{
                        Print.error("Не удалось добавить продукт", " "+product.toString());
                    }
                    break;
                case 2:   
                    String customer_name = Scan.getString("Введите имя покупателя: ");
                    Customer customer = new Customer(customer_name);
                    boolean successAddCustomer = CustomerManager.add(customer);
                    if(successAddCustomer){
                        System.out.println("Покупатель " + customer.toString() + " зарегистрирован");
                    }
                    else{
                        Print.error("Не удалось зарегистрировать покупателя", " "+customer.toString());
                    }
                    break;
                case 3:   
                    Print.printList(products);
                    break;
                case 4:    
                    Print.printList(customers);
                    break;
                case 5:   
                    Print.printList(products);
                    if(products.size() > 0){
                        try{
                            int product_index = Scan.getIndex(products, "Выберите продукт для удаления: ");
                        }catch(NumberFormatException e){
                            Print.error("Неверный индекс");
                        }
                    }
                    break;
                case 6:    
                    Print.printList(customers);
                    if(customers.size() > 0){
                        try{
                            int customer_index = Scan.getIndex(customers, "Выберите покупателя для удаления: ");
                        }catch(NumberFormatException e){
                            Print.error("Неверный индекс");
                        }
                    }
                    break;
                default:
                    Print.error("Нет такой операции");
            }
            System.out.print("\n\n");
        }
        ProductManager.save();
        CustomerManager.save();
        DealManager.save();
    }
    
    //get operation
    private boolean getOperation(){
        boolean gotOperation = false;
        try{
            operation = Scan.getIndex(taskList, "Введите номер операции: ");
            gotOperation = true;
        }catch(NumberFormatException e){
            Print.error("Операция введена неверно");
        }
        return gotOperation;
    }
}
