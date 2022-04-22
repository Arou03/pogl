package M;


public class ZoneM {

    public int x;
    public int y;

    public JoueurM j =  null;

    public enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,
    }

    public Etat etat = Etat.NORMAL;

    /** 
     * initialisation des coordonnées d'une zone
     */
    public ZoneM() { 
        x = -1;
        y = -1;   
    }
    
    /**
     * initialisation se "etat" par "Etat.NORMAL"
     * @param x
     * @param y
     */
    public ZoneM(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * constructeur
     * @param x
     * @param y
     * @param e
     */
    public ZoneM(int x, int y, Etat e) {
        etat = e;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String joueurString = "";
        if(this.j != null)  joueurString = "J";
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
        Boolean resultat;
        if(this.j == null) {
            resultat = false;
        } else {
            resultat = true;
        }
        return resultat;
    }

   //quand tu construis une zone, elles sont normales de base puis on mettra une couleur

}