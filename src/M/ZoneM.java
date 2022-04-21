package M;


public class ZoneM {

    public int x;
    public int y;

    public enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,
    }

    public Etat etat;

    /** 
     * initialisation des coordonnées d'une zone
     */
    public ZoneM() {
        etat = Etat.NORMAL; 
        x = -1;
        y = -1;   
    }
    
    /**
     * initialisation se "etat" par "Etat.NORMAL"
     * @param x
     * @param y
     */
    public ZoneM(int x, int y) {
        etat = Etat.NORMAL;
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

   //quand tu construis une zone, elles sont normales de base puis on mettra une couleur

}