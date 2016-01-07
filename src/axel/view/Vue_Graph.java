package axel.view;

import axel.control.GraphBuilder;
import axel.model.GraphType;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axell on 07/01/16.
 */
public class Vue_Graph extends JPanel {
    Viewer viewer;
    View view;
    private Graph graph;

    Vue_Graph() {
        this.setGraph(GraphBuilder.make(GraphType.GrapheAleatoire, 12, 2));

        this.viewer = new Viewer(this.graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        this.viewer.enableAutoLayout();
        this.view = viewer.addDefaultView(false);   // false indicates "no JFrame".


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

        this.add(view, gbc);
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph _graph) {
        this.graph = _graph;
    }

    public void reload() {
        this.view.repaint();
    }
}