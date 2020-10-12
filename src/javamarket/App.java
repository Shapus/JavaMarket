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
import java.util.Arrays;
import java.util.Scanner;
import tools.files.FileManager;
import tools.managers.CustomerManager;
import tools.managers.DealManager;
import tools.managers.ProductManager;
import utils.Print;

/**
 *
 * @author pupil
 */
public class App {
    
    //file paths
    public static String DIRECTORY_PATH = "data/";
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
            Print.printList(Arrays.asList(taskList));
            if(getOperation()){
                System.out.println(BLUE_BACKGROUND + " " + WHITE + taskList[operation] + " " + RESET);
            }

            switch (operation) {
                case 0:                
                    Print.alert("Выйти из программы? y/n");
                    exit = scanner.nextLine().toLowerCase();
                    break;
                case 1:     
                    System.out.println("Введите название продукта: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите стоимоть продукта: ");
                    System.out.println("Введите количество: ");
                    ProductManager.add();
                    break;
                case 2:   
                    BookManager.deleteBook();
                    break;
                case 3:   
                    Print.printList(books);
                    break;
                case 4:    
                    ReaderManager.addReader();
                    break;
                case 5:   
                    ReaderManager.deleteReader();
                    break;
                case 6:    
                    Print.printList(readers);
                    break;
                case 7:    
                    TrackManager.giveBook();
                    break;
                case 8:    
                    TrackManager.returnBook();
                    break;
                case 9:    
                    TrackManager.getTrack();
                    break;
                case 10:    
                    TrackManager.getTracks();
                    break;
                case 11:    
                    TrackManager.getAllTracks();
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
        String operation_str;
        System.out.print("Выберите операцию: ");
        try{
            operation_str = scanner.nextLine();
            operation = Integer.parseInt(operation_str);
            if(operation > taskList.length-1 || operation < 0){
                throw new NumberFormatException();
            }
            gotOperation = true;
        }catch(NumberFormatException e){
            Print.error("Операция введена неверно");
        }finally{
            return gotOperation;
        }
    }
    }
}
