package M;

import java.util.*;

public class ZoneM {

    final int x;
    final int y;

    JoueurM[] joueurs;

    public enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,
    }

    public Etat etat = Etat.NORMAL;
    
    /**
     * constructeur
     * @param x de type int 
     * @param y de type int
     * @param e de type Etat
     * @param nbJoueur de type int 
     */
    public ZoneM(int x, int y, Etat e, int nbJoueur) {
        this.etat = e;
        this.x = x;
        this.y = y;
        this.joueurs = new JoueurM[nbJoueur];
        for(int i = 0; i < nbJoueur; i++) {
            this.joueurs[i] = null;
        }
    }

    /**
     * méthode getter 
     * @return x; 
     */

    public int getX(){
        return x; 
    }

    /**
     * méthode getter 
     * @return y;  
     */
    public int getY(){
        return y; 
    }

    public JoueurM getJoueur(int id) {
        return joueurs[id];
    }

    public String toString() {
        String joueurString = "";
        for(int i = 0; i < joueurs.length; i++) {
            if(joueurs[i] != null) {
                joueurString += joueurs[i].id;
            } else {
                joueurString += "v";
            }
        }
        return "[ " + joueurString + " (" + this.x + "; " + this.y + ")]";
    }
    

    /**
     * méthode inonde
     * changement de l'état 
     */
    public void innonde() {
        switch(this.etat){
            case NORMAL: 
                this.etat = Etat.INONDEE;
                break;

            case INONDEE:
                this.etat = Etat.SUBMERGEE;
                break;

            case SUBMERGEE:
                break;
        }
    }

    public Boolean contientJoueur() {
        for(int i = 0; i < joueurs.length; i++) {
            if(joueurs[i] != null) return true;
        }
        return false;
    }

    public Boolean contientJoueur(int id) {
        return joueurs[id] != null;
    }
    
    /**
     * si la zone est innondée, on change l'état de la zone en normal
     * @return true
     * sinon @return false
     */
    public Boolean seche() {
        if (this.etat == Etat.INONDEE) {
            this.etat = Etat.NORMAL;
            return true;
        }
        return false;
    } 

}