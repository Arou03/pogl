package V;

import M.JoueurM;

import javax.swing.*;
import java.awt.*;

public class JoueurV extends JPanel {
    final int id;
    private final Color[] playerColors = {
            Color.decode("#0004ff"),
            Color.decode("#db0000"),
            Color.decode("#9d00db"),
            Color.decode("#f6ff00")
    };
    int x, y;
    JoueurM jM;


    /**
     * constructeur
     *
     * @param jM de type JoueurM
     */
    public JoueurV(JoueurM jM) {
        super();
        this.jM = jM;
        this.x = jM.getX();
        this.y = jM.getY();
        this.id = jM.getId();
        this.setPreferredSize(new Dimension(10, 10));
        this.setBackground(playerColors[this.id % 4]);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update() {
        this.x = jM.getX();
        this.y = jM.getY();
    }
}
