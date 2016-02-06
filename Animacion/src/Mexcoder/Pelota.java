/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.Point;

/**
 *
 * @author JuanAntonio
 */
public class Pelota {

    Point cord, direccion, bar1, bar2;
    public int delta = 2;

    public Pelota() {
        direccion = new Point(1, -1);
        cord = new Point(0, 0);
    }

    public Pelota(int x, int y) {
        this();
        this.cord.x = x;
        this.cord.y = y;

    }

    public Point getPoint() {
        return this.cord;
    }

    public int move() { //return 1 if goal on the right -1 on goal on the left else 0
        if (cord.y < 20) {
            this.direccion.y = 1;
        } else if (cord.y > 500) {
            this.direccion.y = -1;
        }
        
        if(cord.x <-10){
            this.cord.x = 100;
            this.cord.y = 100;
            this.direccion.x = 1;
            return -1;
        }
        else if (cord.x > 780){
            this.cord.x = 600;
            this.cord.y = 100;
            this.direccion.x = -1;
            return 1;
        }
        this.cord.x = this.cord.x + delta * direccion.x;
        this.cord.y = this.cord.y + delta * direccion.y;
        return 0;
    }
}
