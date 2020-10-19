/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.User;
import tools.files.FileManager;
import tools.managers.AccountManager;
import tools.managers.DealManager;
import tools.managers.ProductManager;
import tools.managers.UserManager;
import API.APIMethods;
import javamarket.App;
import utils.Print;
import utils.Scan;

/**
 *
 * @author pupil
 */
public class Security {
    private User user;
    private String[] taskList = {
                    "Выйти из программы",
                    "Войти",
                    "Зарегистрироваться",
                    };
    private int operation;
    private String exit;
    public User run(){
        exit = "n";
        while(user == null && exit != "y"){
            Print.printList(taskList);
            operation = Scan.getOperation(taskList);
            if(operation != -1){
                Print.alertln(taskList[operation]);
            }

            switch (operation) {
                case 0:
                    exit = APIMethods.exit();
                    break;
                case 1:
                    user = APIMethods.login();
                    if(checkUser(user)){
                        System.out.println("Здравствуйте, " + user.getLogin());
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++ВХОД В СИСТЕМУ++++++++++++++++++++++++++++++++++++++++++");
                    }else{
                        Print.errorln("Неверно введен логин и/или пароль");
                    }
                    break;
                case 2:
                    APIMethods.registration();
                    break;
                default:
                    Print.error("Нет такой операции");
            }
        }
        return user;
    }
    
    private boolean checkUser(User user){
        return user != null;
    }
    
}
