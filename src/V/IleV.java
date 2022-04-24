package V;

import C.ZoneC;
import IG.Grille;
import M.ileM;


public class IleV extends Grille {
    final public ileM Ile;
    final public ZoneC[][] ileView;
    // Attributs statiques
    public IleV(ileM ile) {
        super(ile.dimension, ile.dimension);
        this.Ile = ile;
        this.ileView = new ZoneC[ile.dimension][ile.dimension];

        for(int i = 0; i < ile.dimension; i++) {
            for(int j = 0; j < ile.dimension; j++) {
                ZoneC z = new ZoneC(ile.getZone(i, j), this);
                ileView[i][j] = z;
                this.ajouteElement(z);
            }
        }
        
        for(int i = 0; i < ile.getNbJoueur(); i++) {
            JoueurV jV = new JoueurV(ile.getJoueur(i));
            ileView[jV.getX()][jV.getY()].poseJoueur(jV);
        }
    }

    public String toString() {
        return Ile.toString() + "\n";
    }
    
    /**
     * Récupérer les coordonnées d'une zone
     * @param x
     * @param y
     * @return les coordonnées de la zone sur le plateau
     */
    public ZoneC getZone(int x, int y) {
        return ileView[x][y];
    }

   
    

    /**
     * actualisation de chaque état des zones sur le plateau
     */
    public void actualise() {
        for(int i = 0; i < this.Ile.dimension; i++) {
            for(int j = 0; j < this.Ile.dimension; j++) {
                this.ileView[i][j].update();
            }
        } 
    }
}


