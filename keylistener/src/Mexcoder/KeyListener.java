/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;

/**
 *
 * @author JuanAntonio
 */
public class KeyListener extends Ventana{

    public KeyListener(){
        super("Key listener: click in the box and  press a key");
        
        this.setLayout(new FlowLayout());
        
        TextField t = new TextField();
        
        Label kt,kp,kr;
        
        kt = new Label("Key Typed");
        
        kp = new Label("Key Pressed");
        
        kr = new Label("Key Released");
        
        kt.setEnabled(false);
        kp.setEnabled(false);
        kr.setEnabled(false);
        
        this.add(kt);
        this.add(kp);
        this.add(kr);
        KeyListener inst = this;
        
        t.setEditable(false);
        this.addKeyListener(new java.awt.event.KeyListener() {
            
            boolean up = true, unique = true;
            @Override
            public void keyTyped(KeyEvent e) {
                if(!unique)
                    return;
                kt.setEnabled(true);
                //inst.setTitle("key :" + e.getKeyText(e.getKeyCode()));
                unique = false;
                
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(!up)
                    return;
                kp.setEnabled(true);
                inst.setTitle("key :" + e.getKeyText(e.getKeyCode()));
                kr.setEnabled(false);
                up = false;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                unique = true;
                up = true;
                kr.setEnabled(true);
                kt.setEnabled(false);
                kp.setEnabled(false);
            }
        });
        //this.add(t);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        execute("");
    }
    
    public static String execute(String s){
        new KeyListener().setVisible(true);
        return "";
    }
    
}
