package mvc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JPanel implements Subscriber {

    public Model model;

    public View(Model model) {

        this.model = model;

        // control panel pink, view panel gray
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //this.update();
        this.model.subscribe(this);
    }

    @Override
    public void update() {
        /*
        When a new model is created, either by choosing New or Open from the
        File menu, the view needs to remove itself as a property change listener
        from the old model and add itself as a property change listener to the new model.
        */
        if(getModel().equals("New") || getModel().equals("Open")){
            model.unsubscribe(this);
            model.subscribe(this);
        }
        this.repaint();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}
