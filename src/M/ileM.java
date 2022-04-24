package M;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import M.ZoneM.Etat;


public class ileM {
    public ZoneM[][] plateau;
    public final int dimension;
    public List<JoueurM> joueurs = new ArrayList<>();
    public int tourEnCours = 0;
     /**
     * constructeur  
     * @param dim de type int 
     * @param nbJoueur de type int
     */

    public ileM(int dim, int nbJoueur){
        this.plateau = new ZoneM[dim][dim];
        this.dimension = dim;
        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) { 
                if(
                 (i + j < 4 && i - j < 4) ||
                 (i + j > 14) ||
                 (i + j > 5 && i - j > 5) ||
                 (i + j > 5 && j - i > 5) 
                 ) {
                    plateau[i][j] = new ZoneM(i, j, Etat.SUBMERGEE, nbJoueur);
                 } else {
                    plateau[i][j] = new ZoneM(i, j, Etat.NORMAL, nbJoueur);
                 }
            }
        }
        for(int i = 0; i < nbJoueur; i++) this.addPlayer(i);
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
                if(cmpt > dimension*dimension) break;
            } while(this.plateau[x][y].etat == Etat.SUBMERGEE);
            this.plateau[x][y].innonde();
        }
        joueurs.get(tourEnCours).nbAction = 0;
        if(tourEnCours == joueurs.size() - 1) {
            tourEnCours = 0;
        } else {
            tourEnCours++;
        }
    }
    

    /**
     * ajout des joueurs
     * @param id
     */
    public void addPlayer(int id) {
        JoueurM j = new JoueurM(0, 0, id);
        joueurs.add(j);
        plateau[j.x][j.y].joueurs.set(id , j);
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
     * @return les coordonnées de l'ancienne zone
     */
    public ZoneM seDeplace(ZoneM z) {
        List<ZoneM> vois = voisins(z);
        ZoneM ancienneZone = null;
        for(int i = 0; i < vois.size(); i++) {
            if(vois.get(i).joueurs.get(tourEnCours) != null && vois.get(i).joueurs.get(tourEnCours).nbAction < 3) {
                vois.get(i).joueurs.get(tourEnCours).seDeplace(z);
                z.joueurs.set(tourEnCours, vois.get(i).joueurs.get(tourEnCours));
                ancienneZone = vois.get(i);
                vois.get(i).joueurs.set(tourEnCours, null);
            }
        }
        return ancienneZone;
    }
}