/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mexcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author JuanAntonio
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(!"-i".equals(args[0]))
            System.out.println(Sort.execute(String.join(" ",args)));
        
        else{
            System.out.print(Sort.getRequestString());
            try{
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                System.out.println(Sort.execute(s));
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
        
        return "enter your lucky numbers mate (space separed)\n";
        
    }
    
    
    public static String execute(String list){//space separed values
        
        try {
            int values[] = Arrays.stream(list.split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(values);
        
            System.out.println("your lucky numbers are:");

            String str = Arrays.toString(values).replaceAll("\\[|\\]|\\s", "");
            return String.join(" ",str.split(","));    
        }
        catch(NumberFormatException e){
            return "it seams that you trow me something that does not look like a number (or atleast java think so)";
        }
          
        
        
    }
}
