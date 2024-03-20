package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {
    private JButton RUN1;
    private JButton RUN50;
    private JButton POPULATE;
    private JButton CLEAR;
    public GridPanel(AppFactory factory) {
        super(factory);
        RUN1 = new JButton("RUN1");
        RUN50 = new JButton("RUN50");
        POPULATE = new JButton("POPULATE");
        CLEAR = new JButton("CLEAR");

        JButton[] buttons = {RUN1, RUN50, POPULATE, CLEAR};
        controlPanel.setLayout(new GridLayout(2, 2));

        JPanel p;
        for (JButton b : buttons) {
            b.addActionListener(this);
            p = new JPanel();
            p.add(b);
            controlPanel.add(p);
        }
    }

    public static void main(String[] args) {}
}
