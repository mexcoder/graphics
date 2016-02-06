/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.Graphics;

/**
 *
 * @author JuanAntonio
 */
public class Monito extends Ventana{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Monito.execute("");
    }
    
    @Override
    public void paint(Graphics g){
        
        //cara
        g.drawArc(50, 60, 50, 50, 0, 360);
        g.drawArc(60,70,30,30,180,180);
        g.fillOval(65, 75, 5, 5);
        g.fillOval(80, 75, 5, 5);
        
        //monoculo xD 
        g.drawArc(60,70,15,15,0,360);
        //g.drawLine(60,70,70,75); //me rindo, dibujar no es lo mio
        //cuerpo
        g.drawLine(75, 110, 75, 200);
        
        //extremidades
        g.drawLine(75, 120, 45, 160);
        g.drawLine(75, 120, 105, 160);
        g.drawLine(75,200,45,240);
        g.drawLine(75,200,105,240);
    
    }

    public Monito() {
        super("el monito :)");
    }
    
    public static String execute(String s){
        new Monito().setVisible(true);
        return "windows created";
    }
    
}
