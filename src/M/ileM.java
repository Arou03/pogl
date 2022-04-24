package M;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import M.ZoneM.Etat;


public class ileM {
    final ZoneM[][] plateau;
    public final int dimension;
    List<JoueurM> joueurs = new ArrayList<>();
    int tourEnCours = 0;
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
                    (i + j < (int) (0.4 * dim) && i - j < (int) (4 * dim)) ||
                    (i + j > (int) (1.4 * dim)) ||
                    (i + j > (int) (0.5 * dim) && i - j > (int) (0.5 * dim)) ||
                    (i + j > (int) (0.5 * dim) && j - i > (int) (0.5 * dim)) 
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
     * méthode getter
     * @param x de type int
     * @param y de type int
     * @return coordonnée de la zone
     */
    public ZoneM getZone(int x, int y) {
        return plateau[x][y];
    }
    
    /**
     * methode getter
     * @param id de type int
     * @return l'id du joueur
     */
    public JoueurM getJoueur(int id) {
        return joueurs.get(id);
    }
    
    /**
     * méthode getter
     * @return le nombre de joueur
     */
    public int getNbJoueur() {
        return joueurs.size();
    }

    /**
     * méthode getter
     * @return le nombre de tour en cours
     */
    public int getTourEnCours() {
        return tourEnCours;
    }

    public void tourSuivant() {
        tourEnCours++;
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
        JoueurM j = new JoueurM(0, (int) this.dimension/2, id);
        joueurs.add(j);
        plateau[j.x][j.y].joueurs[id] = j;
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
            if(vois.get(i).joueurs[tourEnCours] != null && vois.get(i).joueurs[tourEnCours].nbAction < 3) {
                vois.get(i).joueurs[tourEnCours].seDeplace(z);
                z.joueurs[tourEnCours] = vois.get(i).joueurs[tourEnCours];
                ancienneZone = vois.get(i);
                vois.get(i).joueurs[tourEnCours] = null;
            }
        }
        return ancienneZone;
    }

    public Boolean asseche(ZoneM z) {
        if((joueurs.get(tourEnCours).getX()) == z.getX() && (joueurs.get(tourEnCours).getY() == z.getY())) {
            if (z.seche()) {
                joueurs.get(tourEnCours).asseche();
                return true;
            }
        }
        List<ZoneM> vois = voisins(plateau[joueurs.get(tourEnCours).getX()][joueurs.get(tourEnCours).getY()]);
        for(int i = 0; i < vois.size(); i++) {
            if((z.getX() == vois.get(i).getX()) && (z.getY() == vois.get(i).getY())) {
                if (z.seche()) {
                    joueurs.get(tourEnCours).asseche();
                    return true;
                }
            }
        }
        return false;
    }
}