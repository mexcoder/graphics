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
public class Line {
    
    int startx,starty,endx,endy;

    public Line(int startx,int endx, int starty, int endy) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
    }
    
    public void paint(Graphics g){
        g.drawLine(startx, starty, endx, endy);
    }
    
}
