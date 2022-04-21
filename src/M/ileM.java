package M;

import java.util.Random;

import M.ZoneM.Etat;


public class ileM {
    public ZoneM[][] plateau;
    public final int dimension; 

    /**
     * constructeur  
     * @param dim
     */

    public ileM(int dim){
        this.plateau = new ZoneM[dim][dim];
        this.dimension = dim;
        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) { 
                plateau[i][j] = new ZoneM(i, j);
                if(
                 (i + j < 4 && i - j < 4) ||
                 (i + j > 14) ||
                 (i + j > 5 && i - j > 5) ||
                 (i + j > 5 && j - i > 5) 
                 ) plateau[i][j].etat = Etat.SUBMERGEE;
            }
        }
    }

    /**
     * innondation des zones de façon aléatoire
     */

    public void innonde_random() {
        Random r = new Random();
        int x;
        int y;
        int cmpt = 0;
        for(int i = 0; i < 3; i++) {
            do {
                x = r.nextInt(dimension);
                y = r.nextInt(dimension);
                cmpt++;
                if(cmpt > dimension*dimension*dimension) break;
            } while(this.plateau[x][y].etat == Etat.SUBMERGEE);
            this.plateau[x][y].innonde();
        }
    }
}