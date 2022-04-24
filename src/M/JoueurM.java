package M;


public class JoueurM {
    final int id;
    int x;
    int y;
    int nbAction;

    /**
     * constructeur Joueur 
     * @param x de type int 
     * @param y de type int 
     * @param id de type int  
     */
    
    public JoueurM(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    /**
     * methode getter 
     * @return x; 
     */
    public int getX(){
        return x; 
    }
    
     /**
     * methode getter 
     * @return y; 
     */
    public int getY(){
        return y; 
    }

     /**
     * methode getter 
     * @return id; 
     */
    public int getId(){
        return id; 
    }
    
    
     /**
     * methode getter 
     * @return nbAction; 
     */
    public int getNbAction() {
        return nbAction;
    }


    public String toString() {
        return "id :" + id + " (" + x + ", " + y + ")";
    }


    /**
     * le joueur se déplace 
     * @param z de type ZoneM
     */
    public void seDeplace(ZoneM z) {
        this.x = z.x;
        this.y = z.y;
        nbAction++;
    }

    public void asseche() {
        nbAction++;
    }
}