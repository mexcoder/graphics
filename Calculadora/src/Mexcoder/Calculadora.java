/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 *
 * @author JuanAntonio
 */
public class Calculadora extends Ventana {

    final JTextField display;
    float op1;
    int oper; //1 = sum, 2 = res, 3 = mult, 4 = div,0 = echo
    boolean deleteNext = false;

    public void handleInput(String cmd) {
        try {
            Float.parseFloat(cmd);
            if (deleteNext) {
                deleteNext = false;
                display.setText("");
            }
            display.setText(display.getText() + cmd);
        } catch (NumberFormatException e) {
            if (null != cmd) {
                switch (cmd) {
                    case "C":
                        display.setText("");
                        break;
                    case "CA":
                        op1 = 0;
                        oper = 0;
                        break;
                    case "=":
                        deleteNext = true;
                        if (oper != 0) {

                            float res = 0, op2 = Float.parseFloat(display.getText());
                            switch (oper) {
                                case 1:
                                    res = op1 + op2;
                                    break;
                                case 2:
                                    res = op1 - op2;
                                    break;
                                case 3:
                                    res = op1 * op2;
                                    break;
                                case 4:
                                    /*try{*/
                                    res = op1 / op2;
                                    /*}
                                catch(ZeroDivision)*/
                                    break;
                            }

                            display.setText(String.valueOf(res));

                        }
                        break;
                    default:
                        deleteNext = true;
                        //its an operator
                        op1 = Float.parseFloat(display.getText());
                        switch (cmd) {
                            case "+":
                                oper = 1;
                                break;
                            case "-":
                                oper = 2;
                                break;
                            case "*":
                                oper = 3;
                                break;
                            case "/":
                                oper = 4;
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }

        }

    }

    public Calculadora() {
        super("calculadora");
        this.WIDTH = 200;
        this.HEIGHT = 300;
        this.setLayout(new GridBagLayout());

        Panel inner = new Panel();
        inner.setLayout(new GridBagLayout());

        display = new JTextField();
        display.setEnabled(false);

        Button[] buts = new Button[20];
        String Values[] = {"C", "/", "*", "-", "7", "8", "9", "+", "4", "5", "6", "", "1", "2", "3", "=", "0", "", ".", ""}; // "" means an other cell wil take this space
        int[][] spans = {{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 2}, {1, 1}, {1, 1},
        {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 2}, {2,1 }, {1, 1}, {1,1}, {1, 1}};//array that stores the celspan (both x and y) of each cell

        int x = 0, y = 0;

        for (int i = 0; i < buts.length; i++) {
            System.out.println(x + "," + y);
            final String value = Values[i];

            if ("".equals(value)) {
                x++;

                if (x == 4) {
                    x = 0;
                    y++;
                }
                continue;
            }

            buts[i] = new Button(value);
            Button but = buts[i];

            GridBagConstraints c = new GridBagConstraints();
            c.gridx = x;
            c.gridy = y;
            

            c.gridwidth = spans[i][0];
            c.gridheight = spans[i][1];
            c.fill = GridBagConstraints.BOTH;
            c.weighty = 1.0;
            c.weightx = 1.0;

            but.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handleInput(value);
                    super.mouseClicked(e);
                }

            });

            inner.add(but, c);

            x++;

            if (x == 4) {
                x = 0;
                y++;
            }

        }

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        // El campo de texto debe estirarse sólo en horizontal.
        c.fill = GridBagConstraints.HORIZONTAL;

        this.add(display, c);

        c.gridy = 1;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        this.add(inner, c);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        execute("");
    }

    public static String execute(String s) {

        new Calculadora().setVisible(true);

        return "ventana creada";
    }

}
