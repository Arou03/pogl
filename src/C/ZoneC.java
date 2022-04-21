package C;
import java.util.*;
import IG.ZoneCliquable;
import M.ZoneM;
import V.IleV;
import V.JoueurV;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import C.*;
import IG.Grille;
import IG.ZoneCliquable;
import M.*;



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
        Vile.Ile.seDeplace(this.zM);
        Vile.actualise();
    }
    
    /**
     * le joueur se déplace
     */
    @Override
    public void clicDroit() {
        //M.JoueurM.se_deplace();
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
        if(zM.j != null) {
            this.add(new JoueurV(zM.j));
        } else {
            this.removeAll();
        }
    }
}