package C;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import IG.Fenetre;

import javax.swing.Action;

import M.ileM;
import V.IleV;

public class Bouton extends JButton {

    /**
     * création des boutons 
     */
     
    private JButton BoutonFdt = new JButton("Fin de tour");
    private JButton BoutonEnd = new JButton("Exit");
    protected JTextField texte = new JTextField(10);
    protected JLabel label = new JLabel();

    public ileM ile;
    public IleV affiche;
    Fenetre f;

    /**
     * constructeur Bouton 
     * @param f
     * @param ile
     */

    public Bouton (Fenetre f, ileM ile){
        this.f = f;
        this.ile = ile;
        affiche = new IleV(ile);

        f.ajouteElement(affiche);
        f.ajouteElement(BoutonFdt);
        f.ajouteElement(BoutonEnd);


        /**
         * ajout des actions  des boutons 
         */
        BoutonFdt.addActionListener(e ->{
            this.ile.innonde_random();
            this.affiche.actualise();
        });

        BoutonEnd.addActionListener(e ->{
            f.dispose();
        });
    }

}
