package C;
import java.util.*;
import IG.ZoneCliquable;



public class Zone {

    public int x;
    public int y;

    public enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,
    }

    public Etat etat;

    public Zone() {
        etat = Etat.NORMAL; 
        x = -1;
        y = -1;   
    }

    public Zone(int x, int y) {
        etat = Etat.NORMAL;
        this.x = x;
        this.y = y;
    }

    public Zone(int x, int y, Etat e) {
        etat = e;
        this.x = x;
        this.y = y;
    }

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
