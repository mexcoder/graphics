/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author JuanAntonio
 */
public class JVentana extends JFrame{
    int HEIGHT;
    int WIDTH;
    
    protected void appExit(){};

    public JVentana(String titulo) {
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

    
}
