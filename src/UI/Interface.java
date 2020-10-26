/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import entity.Account;
import entity.User;
import tools.managers.AccountManager;
import tools.managers.DealManager;
import tools.managers.ProductManager;
import tools.managers.UserManager;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */

public class Interface{
    //variables
    private static User user;
    private static String exit;
    private static int operation;
    public static String[] adminTaskList = {
                        "Выйти из программы",
                        "Выйти из учетной записи",
                        "Добавить продукт",
                        "Изменить количество",
                        "Список продуктов",
                        "Удалить продукт",
                        "Посмотреть последнюю запись",
                        "Посмотреть последние n записей",
                        "Посмотреть все записи"
                        };
    public static String[] userTaskList = {
                        "Выйти из программы",
                        "Выйти из учетной записи",
                        "Список продуктов",
                        "Купить товар",
                        "Продать товар",
                        "Мои товары",
                        "Текущий счет"
                        };
    public static String[] bankTaskList = {
                        "Выйти из программы",
                        "Выйти из учетной записи",
                        "Список счетов",
                        "Выдать деньги"
                        };
    //admin interface
    public static boolean adminInterface(User user){
        Interface.user = user;
        exit = "n";
        while(exit.equals("n")){
            Print.printList(adminTaskList);
            operation = Scan.getOperation(adminTaskList);
            if(operation != -1){
                Print.alertln(adminTaskList[operation]);
            }
            switch (operation) {
                case 0:                
                    exit = UIMethods.exit();
                    break;
                case 1:                
                    return true;
                case 2:     
                    UIMethods.addProduct();
                    break;
                case 3:     
                    UIMethods.increaseProductQuantity();
                    break;
                case 4:   
                    Print.printList(ProductManager.getProducts());
                    break;
                case 5:   
                    Print.printList(ProductManager.getProducts());
                    UIMethods.deleteProduct();
                    break;
                case 6:
                    Print.printList(DealManager.getLastDeal());
                    break;
                case 7:
                    int count = Scan.getInt("Введите количество записей: ");
                    Print.printList(DealManager.getLastDeals(count));
                    break;
                case 8:
                    Print.printList(DealManager.getDeals());
                    break;
                default:
            }
            System.out.print("\n\n");
        }
        return false;
    }
    
    //user interface
    public static boolean userInterface(User user){
        Interface.user = user;
        exit = "n";
        while(exit.equals("n")){
            Print.printList(userTaskList);
            operation = Scan.getOperation(userTaskList);
            if(operation != -1){
                Print.alertln(userTaskList[operation]);
            }
            switch (operation) {
                case 0:                
                    exit = UIMethods.exit();
                    break;
                case 1:                
                    return true;
                case 2:     
                    Print.printList(ProductManager.getProducts());
                    break;
                case 3:   
                    UIMethods.buyProduct(user);
                    break;
                case 4:   
                    UIMethods.sellProduct(user);
                    break;
                case 5:   
                    Print.printList(user.getProducts());
                    break;
                case 6:   
                    for(Account acc : AccountManager.getAccounts()){
                        if(acc.getId() == user.getAccount()){
                            System.out.println(acc);
                        }
                    }
                    break;
                default:
            }
            System.out.print("\n\n");
        }
        return false;
    }
    
    //bank interface
    public static boolean bankInterface(User user){
        Interface.user = user;
        exit = "n";
        while(exit.equals("n")){
            Print.printList(bankTaskList);
            operation = Scan.getOperation(bankTaskList);
            if(operation != -1){
                Print.alertln(bankTaskList[operation]);
            }
            switch (operation) {
                case 0:                
                    exit = UIMethods.exit();
                    break;
                case 1:                
                    return true;
                case 2:     
                    Print.printList(AccountManager.getAccounts());
                    break;
                case 3:   
                    UIMethods.giveMoney();
                    break;
                default:
            }
            System.out.print("\n\n");
        }
        return false;
    }
}
