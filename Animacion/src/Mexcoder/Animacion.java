/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.BrensenhamCircle;
import Mexcoder.Graphics.Rectangle;
import Mexcoder.Graphics.lineWidth;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author JuanAntonio
 */
public class Animacion extends JVentana {

    /**
     * @param args the command line arguments
     */
    BufferedImage bg, bar, ball;
    Point bar1, bar2, b, score;
    Pelota pel;

    public static void main(String[] args) {
        Animacion v = new Animacion();
        v.setVisible(true);
        v.setResizable(false);

    }

    public Animacion() {
        super("animacion");
        score = new Point(0, 0);
        bg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

        lineWidth l = new lineWidth(bg);
        l.setMask((byte) 0b00000111);
        l.setWidth(5);
        l.draw(WIDTH / 2, 0, WIDTH / 2, HEIGHT - 1, Color.WHITE);

        this.bar = new BufferedImage(100, 250, BufferedImage.TYPE_INT_ARGB);

        Rectangle r = new Rectangle(bar);

        r.draw(1, 1, 20, 150, Color.WHITE);
        r.scanLine(Color.WHITE);

        this.ball = new BufferedImage(101, 101, BufferedImage.TYPE_INT_ARGB);

        BrensenhamCircle c = new BrensenhamCircle(ball);

        c.draw(0, 0, 50, 50, Color.GREEN);
        c.floodFill(Color.GREEN);
        this.pel = new Pelota(100, 100);

        bar1 = new Point(20, 100);
        bar2 = new Point(760, 100);
        b = pel.cord;
        pel.bar1 = bar1;
        pel.bar2 = bar2;

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                int code = e.getKeyCode();
                //System.out.println(code);
                switch (code) {
                    case 38:
                        if (bar2.y > 20) {
                            bar2.y -= 10;
                        }
                        break;
                    case 40:
                        if (bar2.y < 400) {
                            bar2.y += 10;
                        }
                        break;
                    case 87:
                        if (bar1.y > 20) {
                            bar1.y -= 10;
                        }
                        break;
                    case 83:
                        if (bar1.y < 400) {
                            bar1.y += 10;
                        }
                        break;

                }

            }

        });

        JPanel frame = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                g.drawImage(bg, 0, 0, Color.BLACK, this);
                g.drawImage(ball, b.x, b.y, this);
                g.drawImage(bar, bar1.x, bar1.y, this);
                g.drawImage(bar, bar2.x, bar2.y, this);
                

            }
        };

        this.add(frame);

        t = new Timer(0, (ActionEvent e) -> {
            frame.repaint();
            setTitle("Score: " + score.x + " : " + score.y);
            if (b.x <= 40 && bar1.y < b.y && bar1.y + 150 > b.y + 50) {
                pel.direccion.x = 1;
                //pel.direccion.y = pel.direccion.y * -1;
            }
            if (b.x >= 700 && bar2.y < b.y && bar2.y + 150 > b.y + 50) {
                pel.direccion.x = -1;
                //.direccion.y = pel.direccion.y * -1;
            }
            int d = pel.move();

            if (d == -1) {
                score.y = score.y + 1;
            } else if (d == 1) {
                score.x = score.x + 1;
            }
        });
        t.start();

    }
    protected Timer t;

    @Override
    protected void appExit() {
        t.stop();
    }

    @Override
    public void paint(Graphics g) {

        /*g.drawImage(bg, 0, 0, Color.BLACK, this);
        g.drawImage(bar, bar1.x, bar1.y, this);
        g.drawImage(bar, bar2.x, bar2.y, this);
        g.drawImage(ball, b.x, b.y, this);*/
    }

}
