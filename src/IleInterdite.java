import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.Action;
import javax.swing.JButton;

import C.Zone;
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
        IleV affichage = new IleV(modele);
        fenetre.ajouteElement(affichage.p);

        /**
         * création des boutons 
         * et ajout des boutons à notre fenêtre
         */
        JButton b = new JButton("Fin de tour");
    
        JButton q = new JButton("Exit");
        
        q.addActionListener(e->{
            fenetre.dispose();
        });

        b.addActionListener(e->{
            modele.innonde_random();
            affichage.actualise();
        });

        fenetre.ajouteElement(b);
        fenetre.ajouteElement(q);

        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        
        fenetre.dessineFenetre();

       
    }
}

 /*Plateau plateau = new Plateau(nb);
        Validation validation = new Validation(plateau);
        Indice indice = new Indice(plateau);*/