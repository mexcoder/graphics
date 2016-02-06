/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author JuanAntonio
 */
public class Ventana extends Frame {

    int HEIGHT;
    int WIDTH;
    
    protected void appExit(){};

    public Ventana(String titulo) {
        super(titulo);
        this.WIDTH = 800;
        this.HEIGHT = 600;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                appExit();
                dispose();
            }
        }
        );
    }
    
    @Override
    public void setVisible (boolean status){    
        
        this.setSize(this.WIDTH,this.HEIGHT);
        super.setVisible(status);  
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana.execute("");
    }

    public static String execute(String s) {
        Ventana v = new Ventana("hola, te gusta mi ventanita?");
        v.add(new Panel().add(new Label("esta ventana tiene la resolucion de un monitor ctr viejo xD")));
        v.setVisible(true);
        return "ventana creada";

    }

}
