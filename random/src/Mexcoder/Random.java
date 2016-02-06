/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.util.Arrays;

/**
 *
 * @author JuanAntonio
 */
public class Random {
    
    public static boolean needsInput(){
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int lns[] = new int[8];
        
        
        System.out.println("Generating Your Lucky Numbers: ");
        
        for(int x = 0; x<8; x++){
            lns[x] = (new Double(Math.random()*100)).intValue();
            System.out.print(lns[x] + " ");           
            
        }
        System.out.println("");
        System.out.println("mmm thats odd, looks like they are kinda scrambled,aren`t they?, lest fix it");
        
        Arrays.sort(lns);
        
        System.out.println("your lucky numbers are:");
        
        String str = Arrays.toString(lns).replaceAll("\\[|\\]|\\s", "");
        System.out.println(String.join(" ",str.split(",")));
        
        // TODO code application logic here
    }
    
    
    public static String execute(){
        return "not suported";
    }
}
