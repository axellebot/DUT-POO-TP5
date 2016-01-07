package axel.view;

import axel.model.GraphType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axell on 01/12/15.
 */
public class Vue_Principal extends JFrame {
    Vue_Graph viewGraph;
    Vue_Selection viewSelection;
    Vue_Action viewAction;
    Vue_Algo viewAlgo;

    public Vue_Principal() {
        super("TP5");
        setResizable(true);

        this.viewGraph = new Vue_Graph();
        this.viewSelection = new Vue_Selection(this);
        this.viewAction = new Vue_Action();
        this.viewAlgo = new Vue_Algo();

        //ajout à la fenetre avec les contraintes
        //Layout
        this.setLayout(new GridBagLayout());

        //Constraint
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = gbc.gridwidth = 1;
        gbc.weightx = gbc.weighty = 1;
        gbc.gridx = gbc.gridy = 0;

        //ajout
        gbc.gridheight = 5;
        gbc.weightx = 4;
        this.add(viewGraph, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        this.add(viewSelection, gbc);

        gbc.gridy++;
        this.add(viewAction, gbc);

        gbc.gridy += 2;
        this.add(viewAlgo, gbc);
    }

    //choix graph
    private class Vue_Selection extends JPanel {

        private Vue_Principal owner;
        private JButton btnGenerate;
        private JComboBox cbbGraph;

        public Vue_Selection(Vue_Principal owner) {
            this.owner = owner;
            this.setBorder(BorderFactory.createTitledBorder("Choix du graphe"));

            this.cbbGraph = new JComboBox(GraphType.class.getEnumConstants());
            this.add(this.cbbGraph);
            this.btnGenerate = new JButton("Générer");
            this.add(this.btnGenerate);


            this.btnGenerate.addActionListener(e -> {
                System.out.println("Generate " + this.cbbGraph.getSelectedItem());
                GraphConfigDialog dialog = new GraphConfigDialog(this.owner, (GraphType) this.cbbGraph.getSelectedItem());
                viewGraph.setGraph(dialog.showDialog());
                viewGraph.reload();
            });
        }

    }

    //action
    private class Vue_Action extends JPanel {
        private JButton btnExport, btnPonderer;

        public Vue_Action() {
            this.setBorder(BorderFactory.createTitledBorder("Actions"));
            this.btnExport = new JButton("Export PDF");
            this.btnPonderer = new JButton("Pondérer");
            this.add(this.btnExport);
            this.add(this.btnPonderer);
        }

    }

    //Algorithmes
    private class Vue_Algo extends JPanel {
        private JButton btnArbre, btnWelsh, btnDsat;
        private JLabel lblArbre, lblWelsh, lblDsat;

        public Vue_Algo() {
            this.setBorder(BorderFactory.createTitledBorder("Algorithmes"));
            this.btnArbre = new JButton("Arbre Couvrant");
            this.btnWelsh = new JButton("Welsh-Powell");
            this.btnDsat = new JButton("DSat");

            this.lblArbre = new JLabel("");
            this.lblWelsh = new JLabel("");
            this.lblDsat = new JLabel("");

            //ajout à la fenetre avec les contraintes
            //Layout
            this.setLayout(new GridBagLayout());

            //Constraint
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridheight = gbc.gridwidth = 1;
            gbc.weightx = gbc.weighty = 1;
            gbc.gridx = gbc.gridy = 0;


            this.add(this.btnArbre, gbc);
            gbc.gridx++;
            this.add(this.lblArbre, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            this.add(this.btnWelsh, gbc);
            gbc.gridx++;
            this.add(this.lblDsat, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            this.add(this.btnDsat, gbc);
            gbc.gridx++;
            this.add(this.lblWelsh, gbc);
        }

    }

}
