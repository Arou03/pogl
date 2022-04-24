import java.util.InputMismatchException;
import java.util.Scanner;

import C.Bouton;
import IG.Fenetre;
import M.ileM;

public class IleInterdite {
    public static void main(String[] args) {
        int dimension = 10; 
        int nbJoueur = 4;
        Scanner entree = new Scanner(System.in);
        System.out.println("Combien de joueurs voulez-vous ? ");
        try {
            nbJoueur = entree.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide.\n Nombre de joueur par défaut : 4");
        }
        entree.close();

        /**
         * création de la fenêtre 
         * et ajout de notre modèle 
         */
        Fenetre fenetre = new Fenetre( "Ile Interdite");
        ileM modele = new ileM(dimension, nbJoueur);
        Bouton b = new Bouton(fenetre, modele);


        
        fenetre.dessineFenetre();
    }

}

 