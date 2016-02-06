/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import javax.swing.JPanel;

/**
 *
 * @author JuanAntonio
 */
public class ImagePanel extends ScrollPane{
    private Image imagen;

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        
        Dimension d = new Dimension(imagen.getWidth(this),imagen.getHeight(this));
        setPreferredSize(d);
        //setMinimumSize(d);
        setMaximumSize(d);
        update(g);
        
    }
    
    public void update(Graphics g){
        g.drawImage(imagen, 0, 0, this);
    }
       
    
}
