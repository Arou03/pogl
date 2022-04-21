package V;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import C.*;
import IG.Grille;
import IG.ZoneCliquable;
import M.*;


public class IleV {

    public Plateau p;


    /**
     * constructeur 
     * @param modele
     */
    public IleV(ileM modele) {
        this.p = new IleV.Plateau(modele);
    }

    public class Plateau extends Grille {
        private ileM Ile;
        private ZoneC[][] ileView;
        // Attributs statiques
        public Plateau(ileM ile) {
            super(ile.dimension, ile.dimension);
            this.Ile = ile;
            this.ileView = new ZoneC[ile.dimension][ile.dimension];

            for(int i = 0; i < ile.dimension; i++) {
                for(int j = 0; j < ile.dimension; j++) {
                    ZoneC z = new ZoneC(ile.plateau[i][j]);
                    ileView[i][j] = z;
                    this.ajouteElement(z);
                }
            }
            
        }
        /**
         * Récupérer les coordonnées d'une zone
         * @param x
         * @param y
         * @return les coordonnées de la zone sur le plateau
         */
        public ZoneC get_zone(int x, int y) {
            return ileView[x][y];
        }
        
        /**
         * Mise à jour de la zoneVue 
         * @param z
         */
        public void update(ZoneC z) {
            ileView[z.x][z.y] = z;
        }
    }

   
    

    /**
     * actualisation de chaque état des zones sur le plateau
     */
    public void actualise() {
        for(int i = 0; i < this.p.Ile.dimension; i++) {
            for(int j = 0; j < this.p.Ile.dimension; j++) {
                switch(this.p.Ile.plateau[i][j].etat){
                    case NORMAL: 
                        break;
        
                    case INONDEE:
                        this.p.ileView[i][j].setBackground(Color.CYAN);
                        break;
        
                    case SUBMERGEE:
                        this.p.ileView[i][j].setBackground(Color.BLUE);
                        break;
                }
            }
        } 
    }
}


