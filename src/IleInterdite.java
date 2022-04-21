import java.awt.Color;

import C.Bouton;

import java.awt.BorderLayout;

import IG.Fenetre;
import M.ileM;
import V.IleV;

public class IleInterdite {
    public static void main(String[] args) {
        int dimension = 10; 

        /**
         * création de la fenêtre 
         * et ajout de notre modèle 
         */
	    Fenetre fenetre = new Fenetre( "Ile Interdite");
        ileM modele = new ileM(dimension);
        Bouton b = new Bouton(fenetre, modele);



        
        fenetre.setVisible(true);
        
        fenetre.dessineFenetre();
        fenetre.setLocationRelativeTo(null);
    }

}

 /*Plateau plateau = new Plateau(nb);
        Validation validation = new Validation(plateau);
        Indice indice = new Indice(plateau);*/