package CALab;
import java.awt.*;
import javax.swing.*;
import mvc.*;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

public class GridPanel extends AppPanel {
    private JButton run1;
    private JButton run50;
    private JButton populate;
    private JButton clear;

    public GridPanel(AppFactory factory) {
        super(factory);
        run1 = new JButton("RUN1");
        run1.addActionListener(this);
        controlPanel.add(run1);

        run50 = new JButton("RUN50");
        run50.addActionListener(this);
        controlPanel.add(run50);

        populate = new JButton("POPULATE");
        run1.addActionListener(this);
        controlPanel.add(populate);

        clear = new JButton("CLEAR");
        run1.addActionListener(this);
        controlPanel.add(clear);
    }
    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}
