package M;

import java.util.ArrayList;
import java.util.List;
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
        this.addPlayer();
    }

    public String toString() {
        String resultat = "";
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                resultat += plateau[i][j].toString() + " ";
            }
            resultat += " \n";
        }
        return resultat;
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

    public void addPlayer() {
        plateau[0][0].j = new JoueurM(0, 0);
    }
    
    /**
     * récupérer les voisins d'une zone
     * @param z de type ZoneM 
     * @return les coordonnées des voisins dans une liste
     */
    public List<ZoneM> voisins(ZoneM z) {
        List<ZoneM> resultat = new ArrayList<>();
        for(int i = z.x - 1; i < z.x + 2; i = i + 1) {
            for(int j = z.y - 1; j < z.y + 2; j = j + 1) {
                if(
                    (i != z.x | j != z.y) &
                    (i >= 0 & i < dimension) &
                    (j >= 0 & j < dimension)
                )
                resultat.add(plateau[i][j]);
            }
        }
        return resultat;
    }
    
    /**
     * déplace le joueur sur la zone passée en paramètre
     * @param z de type ZoneM 
     * @return les coordonnées des voisins dans une liste
     */
    public ZoneM seDeplace(ZoneM z) {
        List<ZoneM> vois = voisins(z);
        ZoneM ancienneZone = null;
        for(int i = 0; i < vois.size(); i++) {
            if(vois.get(i).j != null) {
                vois.get(i).j.seDeplace(z);
                z.j = vois.get(i).j;
                ancienneZone = vois.get(i);
                vois.get(i).j = null;
            }
        }
        return ancienneZone;
    }
}