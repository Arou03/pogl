package IG;

import javax.swing.*;
import java.awt.*;


/**
 * Classe des fenetres graphiques.
 */
public class Fenetre extends JFrame {

    /**
     * Ensemble des elements contenus dans la fenetre graphique.
     */
    private JPanel elements;

    /**
     * Creation d'une fenetre graphique.
     * <p>
     * Attention, ce constructeur ne fait que definir l'objet. Pour le faire
     * afficher il faut ensuite utiliser la methode {@code dessineFenetre()}.
     *
     * @param nom Nom de la fenetre.
     */
    public Fenetre(String nom) {
        super(nom);
        this.elements = new JPanel();
        elements.setLayout(new GridBagLayout());
        this.add(elements);
    }

    /**
     * Ajout d'un element graphique dans la fenetre.
     *
     * @param element Element a ajouter.
     */
    public void ajouteElement(JComponent element) {
        elements.add(element);
    }

    public void ajouteElement(JComponent element, GridBagConstraints c) {
        elements.add(element, c);
    }

    /**
     * Afficher la fenetre.
     */
    public void dessineFenetre() {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

}
