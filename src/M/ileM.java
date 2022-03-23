package M;

import C.Zone;

public class ileM {
    public Zone[][] plateau;
    public final int dimension; 

   //constructeur 

    public ileM(int dim){
        this.plateau = new Zone[dim][dim];
        this.dimension = dim;
        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) plateau[i][j] = new Zone();
        }
    }
    
    public Zone get(int x, int y) {
        return plateau[x][y];
    }
}