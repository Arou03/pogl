

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JButton;

import C.Zone;
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
        JButton b = new JButton("Fin de tour");
        fenetre.getContentPane().add(b); 
        b.getLocationOnScreen(); //je ne sais pas comment la positionner et quand je met en grand la fenêtre
        //c'est là qu'on voit le bouton
        b.addActionListener(new Action() {
            public void actionPerformed(ActionEvent e){
                Etat.INONDEE(); 
                Etat.SUBMERGEE();
                fenetre.getContentPane().add(e);
            }
        };);
       
    }
}
