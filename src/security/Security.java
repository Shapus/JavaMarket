/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.User;
import UI.UIMethods;
import tools.managers.UserManager;
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
        user = UserManager.getGuest();
        while(exit != "y"){
            Print.printList(taskList);
            operation = Scan.getOperation(taskList);
            if(operation != -1){
                Print.alertln(taskList[operation]);
            }

            switch (operation) {
                case 0:
                    return null;
                case 1:
                    user = UIMethods.login();
                    if(checkUser(user)){
                        return user;
                    }else{
                        Print.errorln("Неверно введен логин и/или пароль");
                    }
                    break;
                case 2:
                    UIMethods.registration();
                    break;
            }
        }
        return user;
    }
    
    private boolean checkUser(User user){
        return user != UserManager.getGuest();
    }
    
}
