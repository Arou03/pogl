package V;



import C.*;
import IG.Grille;
import M.*;


public class IleV extends Grille {
    public ileM Ile;
    public ZoneC[][] ileView;
    // Attributs statiques
    public IleV(ileM ile) {
        super(ile.dimension, ile.dimension);
        this.Ile = ile;
        this.ileView = new ZoneC[ile.dimension][ile.dimension];

        for(int i = 0; i < ile.dimension; i++) {
            for(int j = 0; j < ile.dimension; j++) {
                ZoneC z = new ZoneC(ile.plateau[i][j], this);
                ileView[i][j] = z;
                this.ajouteElement(z);
            }
        }
        
        for(int i = 0; i < ile.joueurs.size(); i++)
            ileView[0][0].add(new JoueurV(ile.plateau[0][0].joueurs.get(i)));
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
        System.out.print(this);
        for(int i = 0; i < this.Ile.dimension; i++) {
            for(int j = 0; j < this.Ile.dimension; j++) {
                this.ileView[i][j].update();
            }
        } 
    }
}


