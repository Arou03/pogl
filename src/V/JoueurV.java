package V;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import M.JoueurM;

public class JoueurV extends JPanel{
    public int x, y;

    public JoueurV(JoueurM jM) {
        super();
        //this.setSize(1/3 * 30, 1/3 * 30);
        //this.setSize(1, 1);
        this.setPreferredSize(new Dimension(6, 6));
        this.setBackground(Color.MAGENTA);
        this.x = jM.x;
        this.y = jM.y;
    }
}
