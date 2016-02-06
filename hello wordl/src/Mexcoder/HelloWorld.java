/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

/**
 *
 * @author JuanAntonio
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(HelloWorld.execute());
    }
    
    public static boolean needsInput(){
        return false;
    }
    
    public static String execute(){
        return "howdy world";
    }

}
