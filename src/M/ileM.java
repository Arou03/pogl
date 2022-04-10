package M;

import java.util.Random;

import C.Zone;
import C.Zone.Etat;

public class ileM {
    public Zone[][] plateau;
    public final int dimension; 

   //constructeur 

    public ileM(int dim){
        this.plateau = new Zone[dim][dim];
        this.dimension = dim;
        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) { 
                plateau[i][j] = new Zone(i, j);
                if(
                 (i + j < 4 && i - j < 4) ||
                 (i + j > 14) ||
                 (i + j > 5 && i - j > 5) ||
                 (i + j > 5 && j - i > 5) 
                 ) plateau[i][j].etat = Etat.SUBMERGEE;
            }
        }
    }

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