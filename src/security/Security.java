/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.User;
import tools.files.FileManager;
import tools.managers.CustomerManager;
import tools.managers.DealManager;
import tools.managers.ProductManager;
import tools.managers.UserManager;
import userinterface.API;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */
public class Security {
    public User user;
    private String[] taskList = {
                    "Выйти из программы",
                    "Войти",
                    "Зарегистрироваться",
                    "Породолжить как гость"
                    };
    private int operation;
    public void run(){
        FileManager.loadAll();
        Print.printList(taskList);
        operation = Scan.getOperation(taskList);
        if(operation != -1){
            Print.alertln(taskList[operation]);
        }
        
        switch (operation) {
            case 0:
                API.exit();
                break;
            case 1:
                user = API.login();
                break;
            case 2:
                API.registeration();
                break;
            case 3:
                
                break;
            default:
                Print.error("Нет такой операции");
        }
    }
    

    
}
