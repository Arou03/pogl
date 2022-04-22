package V;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import M.JoueurM;

public class JoueurV extends JPanel{
    public int id;
    public int x, y;
    public Color[] playerColors= {
        Color.decode("#0004ff"),
        Color.decode("#db0000"),
        Color.decode("#9d00db"),
        Color.decode("#f6ff00")
     };
    public JoueurV(JoueurM jM) {
        super();
        this.x = jM.x;
        this.y = jM.y;
        this.id = jM.id;
        this.setPreferredSize(new Dimension(10, 10));
        this.setBackground(playerColors[this.id % 4]);
    }
}
