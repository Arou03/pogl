import java.util.*;
import IG.*;

public class IleInterdite {
    public static void main(String[] args) {
        int nb = 8;
	    Fenetre fenetre = new Fenetre( nb + "ile");
        /*Plateau plateau = new Plateau(nb);
        Validation validation = new Validation(plateau);
        Indice indice = new Indice(plateau);*/
        ileM modele = new ileM(nb);
        IleV.Plateau affichage = new IleV().new Plateau(nb, modele);
        fenetre.ajouteElement(affichage);

        fenetre.dessineFenetre();
    }
}
