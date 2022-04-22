package V;

import java.awt.Color;

import javax.swing.JPanel;

import M.JoueurM;

public class JoueurV extends JPanel{
    public int x, y;

    public JoueurV(JoueurM jM) {
        super();
        this.setSize(1/3 * 30, 1/3 * 30);
        this.setBackground(Color.DARK_GRAY);
        this.x = jM.x;
        this.y = jM.y;
    }
}
