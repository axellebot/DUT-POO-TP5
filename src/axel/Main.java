package axel;

import axel.view.Vue_Principal;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        //UserInterface
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }
        //IHM
        Vue_Principal _fenetre = new Vue_Principal();
        _fenetre.pack();

        RefineryUtilities.centerFrameOnScreen(_fenetre);
        _fenetre.setVisible(true);
        _fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
