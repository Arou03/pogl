package M;

import java.util.*;

public class ZoneM {

    final int x;
    final int y;

    public List<JoueurM> joueurs = new ArrayList<>();;

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
        for(int i = 0; i < nbJoueur; i++) {
            this.joueurs.add(null);
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
        return joueurs.get(id);
    }

    public String toString() {
        String joueurString = "";
        for(int i = 0; i < joueurs.size(); i++) {
            if(joueurs.get(i) != null) {
                joueurString += joueurs.get(i).id;
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
        for(int i = 0; i < joueurs.size(); i++) {
            if(joueurs.get(i) != null) return true;
        }
        return false;
    }

    public Boolean contientJoueur(int id) {
        return joueurs.get(id) != null;
    }

    public Boolean seche() {
        if (this.etat == Etat.INONDEE) {
            this.etat = Etat.NORMAL;
            return true;
        }
        return false;
    } 

}