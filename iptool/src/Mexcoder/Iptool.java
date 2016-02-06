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
public class Iptool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(Iptool.execute(String.join(" ",args)));
        
    }
    
    public String toIP(String addres){
        String octs[] = new String[4];
        try{
            octs[0] = String.valueOf(Integer.parseInt(addres.substring(0,2),16));
            octs[1] = String.valueOf(Integer.parseInt(addres.substring(2,4),16));
            octs[2] = String.valueOf(Integer.parseInt(addres.substring(4,6),16));
            octs[3] = String.valueOf(Integer.parseInt(addres.substring(6,8),16));
        }
        catch(NumberFormatException  e){
            return "error not a valid ip addres";
        }
        
        
        return String.join(".",octs);
                
    }
    
    public String toHex(String addres){
        String octs[] = addres.split("\\.");// its a regex so must scape the dot
        try{
            for (int i = 0; i < octs.length; i++) {
                octs[i] = Integer.toHexString(Integer.parseInt(octs[i]));
                if(octs[i].length() < 2)
                    octs[i] = "0"+octs[i];
                
            }
            /*octs[0] = String.format("%x",Integer.parseInt(addres.substring(0,2),16));
            octs[1] = String.format("%x",Integer.parseInt(addres.substring(2,4),16));
            octs[2] = String.format("%x",Integer.parseInt(addres.substring(4,6),16));
            octs[3] = String.format("%x",Integer.parseInt(addres.substring(6,8),16));*/
        }
        catch(NumberFormatException  e){
            return "error not a valid hex number";
        }
        
        
        return String.join("",octs).toUpperCase();
    }
    public static String execute(String str){
        String[] args = str.split(" ");
        
        Iptool inst = new Iptool();
        
        if("-ip".equals(args[0])){
            return inst.toHex(args[1]);
        }
        
        if("-hex".equals(args[0])){
           return (inst.toIP(args[1]));
        }
        
        return "no valid parameter suplied";
        
        
        
        
    }
}
