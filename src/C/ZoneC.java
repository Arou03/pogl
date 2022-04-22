package C;
import IG.ZoneCliquable;
import M.ZoneM;
import V.IleV;
import V.JoueurV;

import java.awt.Color;



public class ZoneC extends ZoneCliquable{
    public int x;
    public int y;
    ZoneM zM;
    IleV Vile;


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

        switch(z.etat){
            case NORMAL: 
                this.setBackground(Color.YELLOW);
                break;

            case INONDEE:
                this.setBackground(Color.CYAN);
                break;

            case SUBMERGEE:
                this.setBackground(Color.BLUE);
                break;
        }
    }


    @Override
    public void clicGauche() {
        ZoneM exZone;
        exZone = Vile.Ile.seDeplace(this.zM);
        
        if(exZone != null) {
            System.out.print (exZone.j);
            System.out.print (this.zM.j);
            JoueurV tmp = (JoueurV) Vile.ileView[exZone.x][exZone.y].getComponent(0);
            this.add(tmp);
            revalidate();
            repaint();
            Vile.ileView[exZone.x][exZone.y].remove(tmp);
            Vile.ileView[exZone.x][exZone.y].revalidate();
            Vile.ileView[exZone.x][exZone.y].repaint();
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
                this.setBackground(Color.CYAN);
                break;

            case SUBMERGEE:
                this.setBackground(Color.BLUE);
                break;
        }
    }
}