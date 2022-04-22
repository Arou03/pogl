package M;

import java.util.*;

public class ZoneM {

    public int x;
    public int y;

    public List<JoueurM> joueurs = new ArrayList<>();;

    public enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,
    }

    public Etat etat = Etat.NORMAL;
    
    /**
     * constructeur
     * @param x
     * @param y
     * @param e
     */
    public ZoneM(int x, int y, Etat e, int nbJoueur) {
        this.etat = e;
        this.x = x;
        this.y = y;
        for(int i = 0; i < nbJoueur; i++) {
            this.joueurs.add(null);
        }
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

   //quand tu construis une zone, elles sont normales de base puis on mettra une couleur

}