

import java.awt.Color;

import IG.Fenetre;
import M.ileM;
import V.IleV;

public class IleInterdite {
    public static void main(String[] args) {
        int nb = 8;
	    Fenetre fenetre = new Fenetre( "Ile Interdite");
        /*Plateau plateau = new Plateau(nb);
        Validation validation = new Validation(plateau);
        Indice indice = new Indice(plateau);*/
        ileM modele = new ileM(nb);
        IleV.Plateau affichage = new IleV().new Plateau(nb, modele);
        fenetre.ajouteElement(affichage);
        fenetre.dessineFenetre();
        fenetre.setLocationRelativeTo(null);

    }
}
