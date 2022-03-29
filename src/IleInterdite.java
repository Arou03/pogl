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
	    Fenetre fenetre = new Fenetre( "Ile Interdite");
        /*Plateau plateau = new Plateau(nb);
        Validation validation = new Validation(plateau);
        Indice indice = new Indice(plateau);*/
        ileM modele = new ileM(dimension);
        IleV.Plateau affichage = new IleV().new Plateau(dimension, modele);
        fenetre.ajouteElement(affichage);
        
        JButton b = new JButton("Fin de tour");
        //b.setBounds(0, 0,30,20);
        //fenetre.getContentPane().add(b);
        //fenetre.getContentPane().add(b, BorderLayout.EAST); 
        //fenetre.setVisible(true);
        //b.getLocationOnScreen(); 
        JButton q = new JButton("Exit");
        
        q.addActionListener(e->{
            fenetre.dispose();
        });

        fenetre.ajouteElement(b);
        fenetre.ajouteElement(q);

        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        
        fenetre.dessineFenetre();

       
    }
}
