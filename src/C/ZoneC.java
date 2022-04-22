package C;
import java.awt.Color;
import java.util.Random;

import IG.ZoneCliquable;
import M.ZoneM;
import V.IleV;
import V.JoueurV;



public class ZoneC extends ZoneCliquable{
    public int x;
    public int y;
    ZoneM zM;
    IleV Vile;
    
    Random r = new Random();
     
    Color[] colorsNormal = {Color.decode("#fff9a1"), Color.decode("#6ae66c")};
    Color[] colorsSubmergee = {Color.decode("#2c32a3"), Color.decode("#393fad")};


    /**
     * attribution des couleurs à chaque état de zone
     * @param z
     */
    public ZoneC(ZoneM z, IleV ile) {
        super(30, 30);
        this.x = z.x;
        this.y = z.y;
        this.zM = z;
        this.Vile = ile;
        Random r = new Random();
        switch(z.etat){
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


    @Override
    public void clicGauche() {
        ZoneM exZone;
        exZone = Vile.Ile.seDeplace(this.zM);
        if(exZone != null) {
            JoueurV tmp = (JoueurV) Vile.ileView[exZone.x][exZone.y].getComponent(0);
            this.update();
            this.add(tmp);
            Vile.ileView[exZone.x][exZone.y].remove(tmp);
            Vile.ileView[exZone.x][exZone.y].update();
        }

    }
    
    /**
     * le joueur se déplace
     */
    @Override
    public void clicDroit() {

    }

    /*public void ZONE(Zone SUBMERGEE, Zone INONDEE){
        this.SUBMERGEE = setBackground(Color.GRAY));
        this.INONDEE = setBackground(Color.GREEN); //bref j'en ai marre d

    }*/
    
    /**
     * Mise à jour de la zoneVue 
     * @param z
     */
    public void update() {
        switch(zM.etat){
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