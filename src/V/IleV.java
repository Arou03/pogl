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
        private zoneVue[][] ileView;
        // Attributs statiques
        public Plateau(ileM ile) {
            super(ile.dimension, ile.dimension);
            this.Ile = ile;
            this.ileView = new zoneVue[ile.dimension][ile.dimension];

            for(int i = 0; i < ile.dimension; i++) {
                for(int j = 0; j < ile.dimension; j++) {
                    zoneVue z = new zoneVue(ile.plateau[i][j]);
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
        public zoneVue get_zone(int x, int y) {
            return ileView[x][y];
        }
        
        /**
         * Mise à jour de la zoneVue 
         * @param z
         */
        public void update(zoneVue z) {
            ileView[z.x][z.y] = z;
        }
    }

    public class zoneVue extends ZoneCliquable{
        int x, y;

        public zoneVue(int x, int y) {
            super(30, 30);
            this.x = x;
            this.y = y;
        }
        
        /**
         * attribution des couleurs à chaque état de zone
         * @param z
         */
        public zoneVue(Zone z) {
            super(30, 30);
            this.x = z.x;
            this.y = z.y;
            switch(z.etat){
                case NORMAL: 
                    this.setBackground(Color.YELLOW);
                    break;
    
                case INONDEE:
                    this.setBackground(Color.CYAN);
                    break;
    
                case SUBMERGEE:
                    this.setBackground(Color.BLUE);
                    break;
            }
        }


        @Override
        public void clicGauche() {
            
        }
        
        /**
         * le joueur se déplace
         */
        @Override
        public void clicDroit() {
            M.joueur.se_deplace();
        }

        /*public void ZONE(Zone SUBMERGEE, Zone INONDEE){
            this.SUBMERGEE = setBackground(Color.GRAY));
            this.INONDEE = setBackground(Color.GREEN); //bref j'en ai marre d

        }*/
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


