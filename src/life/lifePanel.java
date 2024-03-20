package life;

import CALab.*;
import mvc.*;

public class lifePanel extends GridPanel {

    public lifePanel(AppFactory factory) { super(factory); }

    public static void main(String[] args) {
        AppFactory factory = new lifeFactory();
        AppPanel panel = new lifePanel(factory);
        panel.display();
    }
}
