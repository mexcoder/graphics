/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.Pixel;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author JuanAntonio
 */
public class MouseListener extends Ventana {
    
    Pixel p;

    public MouseListener() {

        super("MouseListner: move the cursor over the panel");

        MouseListener inst = this;

        Label mc, mp, mr, me, mx, md, mm;
        
        //p = new Pixel(this);

        mc = new Label("Mouse clicked");
        mp = new Label("Mouse Pressed");
        mr = new Label("Mouse Relased");
        me = new Label("Mouse Entered");
        mx = new Label("Mouse Exited");
        md = new Label("Mouse Dragged");
        mm = new Label("Mouse Moved");

        Ventana indicators = new Ventana("status window");
        indicators.setLayout(new FlowLayout());
        indicators.WIDTH = 200;
        indicators.HEIGHT = 250;

        indicators.add(mc);
        indicators.add(mp);
        indicators.add(mr);
        indicators.add(me);
        indicators.add(mx);
        indicators.add(md);
        indicators.add(mm);

        indicators.setVisible(true);
        indicators.setAlwaysOnTop(true);
        indicators.setResizable(false);
        mc.setEnabled(false);
        mp.setEnabled(false);
        mr.setEnabled(false);
        me.setEnabled(false);
        mx.setEnabled(false);
        md.setEnabled(false);
        mm.setEnabled(false);
        Thread t = new Thread(
                new Runnable() {
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MouseListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                mm.setEnabled(false);

            }
        });

        //runnable.run();
        MouseInputListener m = new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                mc.setEnabled(true);
                Point pe = e.getPoint();
                //p.draw(pe.x, pe.y);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                mp.setEnabled(true);
                mr.setEnabled(false);
                mc.setEnabled(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
                mr.setEnabled(true);
                mp.setEnabled(false);
                md.setEnabled(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                me.setEnabled(true);
                mx.setEnabled(false);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                mx.setEnabled(true);
                me.setEnabled(false);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                md.setEnabled(true);
                /*t.interrupt();
                t.run();*/
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mm.setEnabled(true);
                Point p = e.getPoint();
                inst.setTitle("MouseListner: cursor is in {x: " + p.x + " , y: " + p.y + "}");
                t.interrupt();
                t.run();

            }
        };
        this.addMouseMotionListener(m);
        this.addMouseListener(m);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        execute("");
    }

    public static String execute(String s) {
        new MouseListener().setVisible(true);
        return "have fun";

    }
}
