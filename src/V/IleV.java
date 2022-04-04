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

        public zoneVue get_zone(int x, int y) {
            return ileView[x][y];
        }

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

        @Override
        public void clicDroit() {
        }

        /*public void ZONE(Zone SUBMERGEE, Zone INONDEE){
            this.SUBMERGEE = setBackground(Color.GRAY));
            this.INONDEE = setBackground(Color.GREEN); //bref j'en ai marre d

        }*/
    }

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


