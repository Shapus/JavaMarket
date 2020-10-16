/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamarket;

import security.Security;

/**
 *
 * @author pupil
 */
public class JavaMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        Security security = new Security();
        security.run();
        app.run();
    }
    
}
