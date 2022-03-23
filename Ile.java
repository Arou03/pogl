import IG.*;
import java.util.*;

public class Ile {

    private ArrayList<ArrayList<Ile>>zone;

        
    enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,

    }

    //constructeur
    public Ile(){
        this.zone = new ArrayList<ArrayList<>();
    }

    // pourquoi faire une arrayList si pour afficher le jeu c'est deja avec 
    // le fichier IG et il faut juste changer quelque manip 
    //par exemple inondée une zone , on fait juste clicdroit 

   /* public static void main(String[] args) {
        int nb = 8;
	    Fenetre fenetre = new Fenetre( nb + "ile");
        fenetre.dessineFenetre();
        Plateau plateau = new Plateau(nb);
        Validation validation = new Validation(plateau);
        Indice indice = new Indice(plateau);
    }

    class Validation extends ZoneCliquable {
        private Plateau plateau;
        
        public Validation(Plateau p) {
        // Création d'une zone cliquable de dimensions 80*25 pixels,
        // et contenant le texte "Valider".
        super("Valider", 80, 25);
        this.plateau = p;
        }
        public void clicGauche() {
        if (plateau.verifieConfiguration()) {
        setBackground(Color.GREEN);
        } else {
        setBackground(Color.RED);
        }
        }
        public void clicDroit() {}
       }*/
    
}
