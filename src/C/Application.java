package C;

import IG.Fenetre;
import IG.Texte;
import M.ileM;
import V.IleV;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    /**
     * constructeur Application
     *
     * @param f
     * @param ile
     */
    public Application() {
    }

    public static void creerLaFenetre() {
        Scanner entree = new Scanner(System.in);
        int dimension = 10;
        int nbJoueur = 4;
        System.out.println("Quelle sera la taille du plateau ? ");
        try {
            dimension = entree.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide.\n Taille par défaut : 10");
        }
        System.out.println("Combien de joueurs voulez-vous ? ");
        try {
            nbJoueur = entree.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide.\n Nombre de joueur par défaut : 4");
        }
        entree.close();

        /**
         * création des boutons
         */
        JButton BoutonFdt = new JButton("Fin de tour");
        JButton BoutonEnd = new JButton("Exit");

        Texte AfficheTour = new Texte("");
        Texte AfficheAction = new Texte("");

        /**
         * création de la fenêtre
         * et ajout de notre modèle
         */
        Fenetre fenetre = new Fenetre("Ile Interdite");
        ileM modele = new ileM(dimension, nbJoueur);
        IleV Vue = new IleV(modele);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridheight = 10;
        c.gridwidth = 10;
        c.gridx = 0;
        c.gridy = 0;
        fenetre.ajouteElement(Vue, c);
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 11;
        c.gridy = 0;
        AfficheTour.changeTexte("Tour du joueur " + (modele.getTourEnCours() + 1));
        fenetre.ajouteElement(AfficheTour, c);
        c.gridy = 1;
        AfficheAction.changeTexte("Nombre d'action restantes : " + (3 - modele.getJoueur(modele.getTourEnCours()).getNbAction()));
        fenetre.ajouteElement(AfficheAction, c);
        c.gridy = 2;
        fenetre.ajouteElement(BoutonFdt, c);
        c.gridy = 3;
        fenetre.ajouteElement(BoutonEnd, c);

        /**
         * ajout des actions  des boutons
         */
        BoutonFdt.addActionListener(e -> {
            modele.innonde_random();
            AfficheTour.changeTexte("Tour du joueur " + (modele.getTourEnCours() + 1));
            Vue.actualise();
        });

        BoutonEnd.addActionListener(e -> {
            fenetre.dispose();
        });

        fenetre.dessineFenetre();
    }

    public void update(Texte AfficheTour, Texte AfficheAction, ileM ile) {
        AfficheTour.changeTexte("Tour du joueur " + (ile.getTourEnCours() + 1));
        AfficheAction.changeTexte("Nombre d'action restantes : " + (3 - ile.getJoueur(ile.getTourEnCours()).getNbAction()));
    }
}
