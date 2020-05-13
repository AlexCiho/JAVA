package sample;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {

    public static final int W = 1000, H = 800;
    Random valueGenerator = new Random();
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }

    public void addAtRandomLocation(JComponent comp) {
        int x = valueGenerator.nextInt(W - 1);
        int y = valueGenerator.nextInt(H - 1);
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;

        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
}
