package V;

import java.awt.Color;
import java.awt.Dimension;

import C.Zone;
import IG.Grille;
import IG.ZoneCliquable;
import M.ileM;


public class IleV {

    public class Plateau extends Grille {
        private ileM Ile;
        private zoneVue[][] ileview;
        // Attributs statiques
        public Plateau(int dim, ileM ile) {
            super(dim, dim);
            this.Ile = ile;

            for(int i = 0; i < dim; i++) {
                for(int j = 0; j < dim; j++) {
                    Ile.plateau[i][j] = new Zone();
                    this.ajouteElement(new zoneVue(i, j));
                }
            }
            
        }
    }

    public class zoneVue extends ZoneCliquable{

        public zoneVue(int x, int y) {
            super(x, y);

            this.setPreferredSize(new Dimension(30, 30));
        }

        @Override
        public void clicGauche() {
            setBackground(Color.BLUE);
        }

        @Override
        public void clicDroit() {
            setBackground(Color.magenta);
        }
        
    }
}


