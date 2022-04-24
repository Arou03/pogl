package C;

import IG.ZoneCliquable;
import M.ZoneM;
import V.IleV;
import V.JoueurV;

import java.awt.*;
import java.util.Random;


public class ZoneC extends ZoneCliquable {
    public int x;
    public int y;
    ZoneM zM;
    IleV Vile;
    JoueurV[] joueurs;

    Random r = new Random();

    Color[] colorsNormal = {Color.decode("#fff9a1"), Color.decode("#6ae66c")};
    Color[] colorsSubmergee = {Color.decode("#2c32a3"), Color.decode("#393fad")};


    /**
     * attribution des couleurs à chaque état de zone
     *
     * @param z
     */
    public ZoneC(ZoneM z, IleV ile) {
        super(30, 30);
        this.x = z.getX();
        this.y = z.getY();
        this.zM = z;
        this.Vile = ile;
        this.joueurs = new JoueurV[ile.Ile.getNbJoueur()];
        for (int i = 0; i < ile.Ile.getNbJoueur(); i++) joueurs[i] = null;
        Random r = new Random();
        switch (z.etat) {
            case NORMAL:
                this.setBackground(colorsNormal[r.nextInt(colorsNormal.length)]);
                break;

            case INONDEE:
                this.setBackground(Color.decode("#5cd6ff"));
                break;

            case SUBMERGEE:
                this.setBackground(colorsSubmergee[r.nextInt(colorsSubmergee.length)]);
                break;
        }
    }

    public void poseJoueur(JoueurV j) {
        joueurs[j.getId()] = j;
        this.add(j);
    }

    public void retireJoueur(int i) {
        this.remove(joueurs[i]);
        joueurs[i] = null;
    }

    public JoueurV getJoueur(int i) {
        return joueurs[i];
    }

    /**
     * le joueur se déplace grâce au clic gauche de la souris
     */
    @Override
    public void clicGauche() {
        ZoneM exZone;
        exZone = Vile.Ile.seDeplace(this.zM);
        if (exZone != null) {
            System.out.println("tour en cours : " + Vile.Ile.getTourEnCours());
            JoueurV tmp = Vile.ileView[exZone.getX()][exZone.getY()].getJoueur(Vile.Ile.getTourEnCours());
            this.poseJoueur(tmp);
            this.update();
            Vile.ileView[exZone.getX()][exZone.getY()].retireJoueur(Vile.Ile.getTourEnCours());
            Vile.ileView[exZone.getX()][exZone.getY()].update();
            tmp.update();
        }

    }

    /**
     * assèche la zone grâce au clic droit de la souris
     */
    @Override
    public void clicDroit() {
        if (Vile.Ile.getJoueur(Vile.Ile.getTourEnCours()).getNbAction() < 3)
            if (Vile.Ile.asseche(this.zM)) this.setBackground(this.colorsNormal[0]);
    }

    /**
     * Mise à jour de la zoneVue
     *
     * @param z
     */
    public void update() {
        switch (zM.etat) {
            case NORMAL:
                break;

            case INONDEE:
                this.setBackground(Color.decode("#5cd6ff"));
                break;

            case SUBMERGEE:
                this.setBackground(colorsSubmergee[r.nextInt(colorsSubmergee.length)]);
                break;
        }
        revalidate();
        repaint();
    }
}