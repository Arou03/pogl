package V;

import javax.swing.JPanel;

import M.JoueurM;

public class JoueurV extends JPanel{
    public int x, y;
    public JoueurV(JoueurM jM) {
        super();
        this.x = jM.x;
        this.y = jM.y;
    }
}
