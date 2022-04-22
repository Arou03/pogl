package C;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import IG.Fenetre;
import IG.Texte;
import M.ileM;
import V.IleV;

public class Bouton extends JButton {

    /**
     * création des boutons 
     */
     
    private JButton BoutonFdt = new JButton("Fin de tour");
    private JButton BoutonEnd = new JButton("Exit");
    protected Texte AfficheTour = new Texte("");
    protected Texte AfficheAction = new Texte("");

    public ileM ile;
    public IleV Vue;
    Fenetre f;

    /**
     * constructeur Bouton 
     * @param f
     * @param ile
     */

    public Bouton (Fenetre f, ileM ile){
        this.f = f;
        this.ile = ile;
        Vue = new IleV(ile);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridheight = 10;
        c.gridwidth = 10;
        c.gridx = 0;
	    c.gridy = 0;
        f.ajouteElement(Vue, c);
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
	    c.gridx = 11;
        c.gridy = 0;
        AfficheTour.changeTexte("Tour du joueur " + (ile.tourEnCours + 1) );
        f.ajouteElement(AfficheTour, c);
        c.gridy = 1;
        AfficheAction.changeTexte("Nombre d'action restantes : " + (3 - ile.joueurs.get(ile.tourEnCours).nbAction) );
        f.ajouteElement(AfficheAction, c);
        c.gridy = 2;
        f.ajouteElement(BoutonFdt, c);
        c.gridy = 3;
        f.ajouteElement(BoutonEnd, c);


        /**
         * ajout des actions  des boutons 
         */
        BoutonFdt.addActionListener(e ->{
            this.ile.innonde_random();
            AfficheTour.changeTexte("Tour du joueur " + (ile.tourEnCours + 1) );
            this.Vue.actualise();
        });

        BoutonEnd.addActionListener(e ->{
            f.dispose();
        });
    }

    public void update() {
        AfficheTour.changeTexte("Tour du joueur " + (ile.tourEnCours + 1) );
        AfficheAction.changeTexte("Nombre d'action restantes : " + (3 - ile.joueurs.get(ile.tourEnCours).nbAction) );
    }
}
