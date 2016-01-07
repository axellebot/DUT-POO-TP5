package axel.model;

/**
 * Created by axell on 07/01/16.
 */
public enum GraphType {
    Cycle("Cycle"),
    Chaine("Chaine"),
    Tore("Tore"),
    GrilleCarre("Grille Carré"),
    ArbreComplet("Arbre n-aire complet"),
    GrapheAleatoire("Graphe Aleatoire");

    private final String name;

    GraphType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}