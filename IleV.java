import IG.*;

import java.awt.Color;
import java.awt.Dimension;
import java.util.*;


public class IleV {

    public class Plateau extends Grille {
        private ileM Ile;

        // Attributs statiques
        public Plateau(int dim, ileM ile) {
            super(dim, dim);
            this.Ile = ile;

            for(int i = 0; i < dim; i++) {
                for(int j = 0; j < dim; j++) {
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
            setBackground(Color.BLACK);
        }

        @Override
        public void clicDroit() {
            setBackground(Color.white);
        }
        
    }
}


