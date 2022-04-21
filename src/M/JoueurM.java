package M;

import C.ZoneC;


public class JoueurM {
    int x;
    int y;

    /**
     * constructeur Joueur 
     * param int x, int y 
     */
    
    public JoueurM(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * le joueur se déplace 
     * param Zone z
     */
    public void seDeplace(ZoneC z) {
        this.x = z.x;
        this.y = z.y;
    }
}