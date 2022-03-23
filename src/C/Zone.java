package C;

import java.util.*;

import IG.ZoneCliquable;

public class Zone {
    enum Etat{
        NORMAL,
        INONDEE,
        SUBMERGEE,
    }

    Etat etat;

    public Zone() {
        etat = Etat.NORMAL;    
    }

   //quand tu construis une zone, elles sont normales de base puis on mettra une couleur
}
