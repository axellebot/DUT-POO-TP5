package axel.control;

import axel.model.GraphType;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.GridGenerator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * Created by axell on 07/01/16.
 */
public class GraphBuilder {

    public static Graph make(GraphType t, int... parametres) {
        switch (t) {
            case Cycle:
                return Cycle(parametres[0]);
            case Chaine:
                return Chaine(parametres[0]);
            case Tore:
                return Tore(parametres[0]);
            case GrilleCarre:
                return GrilleCarre(parametres[0]);
            case ArbreComplet:
                return ArbreComplet(parametres[0], parametres[1]);
            case GrapheAleatoire:
                return GrapheAleatoire(parametres[0], parametres[1]);
            default:
                return null;
        }
    }


    /**
     * @param _nbSommet nombre de sommets
     * @return
     */
    private static Graph Cycle(int _nbSommet) {
        return null;
    }

    /**
     * @param _nbSommet nombre de sommets
     * @return
     */
    private static Graph Chaine(int _nbSommet) {
        return null;
    }

    /**
     * @param _taille taille
     * @return
     */
    private static Graph Tore(int _taille) {
        Graph graph = new SingleGraph("grid");
        Generator gen = new GridGenerator(false, true);

        gen.addSink(graph);
        gen.begin();
        for (int i = 0; i < _taille; i++) {
            gen.nextEvents();
        }
        gen.end();

        // Nodes already have a position.
        return graph;
    }

    /**
     * @param _tailleCote taille du coté
     * @return
     */
    private static Graph GrilleCarre(int _tailleCote) {
        Graph graph = new SingleGraph("grid");
        Generator gen = new GridGenerator();

        gen.addSink(graph);
        gen.begin();
        for (int i = 0; i < _tailleCote; i++) {
            gen.nextEvents();
        }
        gen.end();

        // Nodes already have a position.
        return graph;
    }

    /**
     * @param _hauteur hauteur
     * @param _nbFils  nombre de fils pour chaque nœud
     * @return
     */
    private static Graph ArbreComplet(int _hauteur, int _nbFils) {
        return null;
    }

    /**
     * @param _nbSommet   nombre de sommets
     * @param _degreMoyen degré moyen
     * @return
     */
    private static Graph GrapheAleatoire(int _nbSommet, int _degreMoyen) {
        Graph graph = new SingleGraph("Random");
        Generator gen = new RandomGenerator(_degreMoyen);
        gen.addSink(graph);
        gen.begin();
        for (int i = 0; i < _nbSommet; i++) {
            gen.nextEvents();
        }
        gen.end();
        return graph;
    }
}

