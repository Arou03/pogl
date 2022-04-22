package V;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import M.JoueurM;

public class JoueurV extends JPanel{
    public int x, y;

    public JoueurV(JoueurM jM) {
        super();
        this.setPreferredSize(new Dimension(20, 20));
        this.setBackground(Color.DARK_GRAY);
        this.x = jM.x;
        this.y = jM.y;
    }
}
