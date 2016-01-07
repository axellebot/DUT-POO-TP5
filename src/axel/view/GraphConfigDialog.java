package axel.view;

import axel.control.GraphBuilder;
import axel.model.GraphType;
import org.graphstream.graph.Graph;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axell on 07/01/16.
 */
public class GraphConfigDialog extends JDialog {
    private JButton btnAnnuler, btnValider;
    private JLabel lbl1, lbl2;
    private JTextField txt1, txt2;
    private JPanel panel;

    private Graph graph;
    private GraphType graphType;

    public GraphConfigDialog(Vue_Principal owner, GraphType graphType) {
        super(owner, "Config", true);

        this.graphType = graphType;

        this.setBackground(Color.WHITE);

        this.panel = new JPanel();

        this.lbl1 = new JLabel("");
        this.lbl2 = new JLabel("");
        this.txt1 = new JTextField("");
        this.txt2 = new JTextField("");
        this.btnValider = new JButton("Valider");
        this.btnValider.setBackground(Color.GREEN);

        this.btnAnnuler = new JButton("Annuler");
        this.btnAnnuler.setBackground(Color.RED);

        initialisation();

        this.add(panel);
        this.btnValider.addActionListener(e -> {
                    switch (this.graphType) {

                        case Cycle:
                        case Chaine:
                        case Tore:
                        case GrilleCarre:
                            this.graph = GraphBuilder.make(this.graphType, Integer.parseInt(txt1.getText()));
                            break;
                        case ArbreComplet:
                        case GrapheAleatoire:
                            this.graph = GraphBuilder.make(this.graphType, Integer.parseInt(txt1.getText()), Integer.parseInt(txt2.getText()));
                            break;
                    }
                    this.setVisible(false);
                }

        );

        this.btnAnnuler.addActionListener(e -> {
                    this.graph = null;
                    this.setVisible(false);
                }
        );
    }

    public void initialisation() {
        switch (this.graphType) {
            case GrapheAleatoire:
                lbl2.setText("Degré moyen : ");
            case Cycle:
            case Chaine:
                lbl1.setText("Nombre de sommets : ");
                break;
            case Tore:
                lbl1.setText("Taille : ");
                break;
            case GrilleCarre:
                lbl1.setText("Taille du coté : ");
                break;
            case ArbreComplet:
                lbl1.setText("Hauteur");
                lbl2.setText("Nombres de fils pour chaque noeud");
                break;
        }


        //Layout
        this.panel.setLayout(new GridBagLayout());

        //Constraint
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = gbc.gridwidth = 1;
        gbc.weightx = gbc.weighty = 1;
        gbc.gridx = gbc.gridy = 0;

        //ajout

        switch (this.graphType) {
            case Cycle:
            case Chaine:
            case Tore:
            case GrilleCarre:
                this.panel.add(lbl1, gbc);
                gbc.gridx++;
                this.panel.add(txt1, gbc);
                break;
            case ArbreComplet:
            case GrapheAleatoire:
                this.panel.add(lbl1, gbc);
                gbc.gridx++;
                this.panel.add(txt1, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                this.panel.add(lbl2, gbc);
                gbc.gridx++;
                this.panel.add(txt2, gbc);
                break;
        }
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy++;
        this.panel.add(btnValider, gbc);
        gbc.gridy++;
        this.panel.add(btnAnnuler, gbc);
    }

    public Graph showDialog() {
        this.setVisible(true);//on ouvre la fenêtre
        return this.graph;//on retourne Le résultat
    }
}
