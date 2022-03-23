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
}
