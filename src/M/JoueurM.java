package M;

import C.ZoneC;


public class JoueurM {
    public String id = "";
    public int x;
    public int y;

    /**
     * constructeur Joueur 
     * param int x, int y 
     */
    
    public JoueurM(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "id :" + id + " (" + x + ", " + y + ")\n";
    }
    

    /**
     * le joueur se déplace 
     * param Zone z
     */
    public void seDeplace(ZoneM z) {
        System.out.print(this);
        this.x = z.x;
        this.y = z.y;
        System.out.print(this);
    }
}