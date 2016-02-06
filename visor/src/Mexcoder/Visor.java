/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JuanAntonio
 */
public class Visor extends Ventana {

    MenuBar menu;
    final MenuItem mItem;
    ImagePanel iPane;
    ScrollPane pane;

    public Visor() {

        super("el visior");
        this.WIDTH = 600;
        this.HEIGHT = 600;
        menu = new MenuBar();
        mItem = new MenuItem("cargar imagen");
        mItem.addActionListener((ActionEvent e) -> {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "PNG, JPG & GIF Images", "png", "jpg", "gif");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: "
                        + chooser.getSelectedFile().getName());
                ImageIcon icon = new ImageIcon(chooser.getSelectedFile().toString());
                iPane.setImagen(icon.getImage());
                iPane.repaint();
                

            }

        });
        Menu m = new Menu("Archivo");
        m.add(mItem);
        menu.add(m);
        this.setMenuBar(menu);

        iPane = new ImagePanel();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("default-placeholder.png"));
        iPane.setImagen(icon.getImage());

        pane = new ScrollPane();

        pane.add(iPane);

        this.add(pane);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        execute("");
    }

    public static String execute(String s) {

        new Visor().setVisible(true);

        return "loaded";
    }

}
