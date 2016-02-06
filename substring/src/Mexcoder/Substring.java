/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author JuanAntonio
 */
public class Substring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(!"-i".equals(args[0]))
            System.out.println(Substring.execute(String.join(" ",args)));
        
        else{
            System.out.print(Substring.getRequestString());
            try{
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                System.out.println(Substring.execute(s));
            }
            catch(IOException e)
            {
                    e.printStackTrace();
            }
        }
        
    }

    public static boolean needsInput(){
        return true;
    }
    
    public static String getRequestString(){
        
        return "enter your string\n";
        
    }
    
    
    public static String execute(String str){//space separed values
        
        String ret = "";
        
        for(int x = 0; x < str.length(); x++){
            ret+= str.substring(0,x+1)+"\n";
            ret+= str.substring(str.length()-x-1)+"\n";
        }
        
        
        
       return ret;         
    }
    
}
