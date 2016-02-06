/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author JuanAntonio
 */
public class Espiral extends Ventana {

    double alpha = 0.1;
    double offsetX, offsetY;
    
    LinkedList<Line> lines;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Espiral.execute("");
    }

    public Espiral() {
        super("La Espiral De Arquimides!!!!");  
        
        this.lines = new LinkedList<Line>();
        this.HEIGHT = 600;
        this.WIDTH = 600;
        this.offsetX = this.HEIGHT / 2;
        this.offsetY = this.WIDTH / 2;
    }

    public void draw() {
        this.setVisible(true);
        final int offx = (int) this.offsetX, offy = (int) this.offsetY;
        final double alpha = this.alpha; 
        final Graphics g = this.getGraphics();
        Runnable runnable = new Runnable() {
            public void run() {
                int lastX = (int) offx;
                int lastY = (int) offy;
                for (int i = 0; i < 7200; i++) {
                    Double angle = alpha * i;
                    int x = (int) ((1 + angle) * Math.cos(angle) + offx);
                    int y = (int) ((1 + angle) * Math.sin(angle) + offx);
                    lines.add(new Line(lastX,x,lastY,y));
                    repaint();
                    
                    lastX = x;
                    lastY = y;
                    System.out.println("drawing" + x +","+"y");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Espiral.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        };
        runnable.run();
    }

    public double drawX(Graphics g, double t, double last) {
        return alpha * t * Math.cos(t);
    }

    public double getY(Graphics g, double t, double last) {
        return alpha * t * Math.sin(t);
    }

    public void paint(Graphics g, int lastX, int x, int lastY, int y) {

        super.update(g);
        g.drawLine(lastX, lastY, x, y);

    }

    public void paint(Graphics g) {
        
        for (Line l : lines) {
            l.paint(g);
        }

        /*int lastX = (int) this.offsetX;
        int lastY = (int) this.offsetY;
        for (int i=0; i< 7200; i++) {
            Double angle = this.alpha * i;
            int x = (int) ((1+angle)*Math.cos(angle) + this.offsetX);
            int y = (int) ((1+angle)*Math.sin(angle) + this.offsetY);
            g.drawLine(lastX,lastY,x, y);
            lastX = x;
            lastY = y;
          }
         */
    }

    public static String execute(String s) {

        new Espiral().draw();

        return "ventana creada, corriendo thread para dibujar";
    }

}
