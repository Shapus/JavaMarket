/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import entity.User;
import static javamarket.App.taskList;
import tools.managers.AccountManager;
import tools.managers.DealManager;
import tools.managers.ProductManager;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */

public class APIInterface{
    //variables
    private static User user;
    private static String exit;
    private static int operation;
    public static String[] adminTaskList = {
                        "Выйти из программы",
                        "Добавить продукт",
                        "Список продуктов",
                        "Удалить продукт",
                        "Посмотреть последнюю запись",
                        "Посмотреть последние n записей",
                        "Посмотреть все записи"
                        };
    public static String[] userTaskList = {
                        "Выйти из программы",
                        "Список продуктов",
                        "Купить продукт"
                        };
    
    //admin interface
    public static void adminInterface(User user){
        APIInterface.user = user;
        exit = "n";
        while(exit.equals("n")){
            Print.printList(adminTaskList);
            operation = Scan.getOperation(adminTaskList);
            if(operation != -1){
                Print.alertln(adminTaskList[operation]);
            }
            switch (operation) {
                case 0:                
                    exit = APIMethods.exit();
                    break;
                case 1:     
                    APIMethods.addProduct();
                    break;
                case 2:   
                    Print.printList(ProductManager.getProducts());
                    break;
                case 3:   
                    Print.printList(ProductManager.getProducts());
                    APIMethods.deleteProduct();
                    break;
                case 4:
                    Print.printList(DealManager.getLastDeal());
                    break;
                case 5:
                    int count = Scan.getInt("Введите количество записей: ");
                    Print.printList(DealManager.getLastDeals(count));
                    break;
                case 6:
                    Print.printList(DealManager.getDeals());
                    break;
                default:
                    Print.errorln("Нет такой операции");
            }
            System.out.print("\n\n");
        }
        
    }
    
    //user interface
    public static void userInterface(User user){
        APIInterface.user = user;
        exit = "n";
        while(exit.equals("n")){
            Print.printList(userTaskList);
            operation = Scan.getOperation(userTaskList);
            if(operation != -1){
                Print.alertln(userTaskList[operation]);
            }
            switch (operation) {
                case 0:                
                    exit = APIMethods.exit();
                    break;
                case 1:     
                    Print.printList(ProductManager.getProducts());
                    break;
                case 2:   
                    APIMethods.buyProduct(user);
                    break;
                default:
                    Print.errorln("Нет такой операции");
            }
            System.out.print("\n\n");
        }
    }
}
