package CALab;

import java.util.*;
import java.awt.Color;
import java.io.*;
import mvc.*;

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;



    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
            Cell[] partnerOptions = neighbors.toArray(new Cell[0]);
            Random random = new Random();
            int start = random.nextInt(partnerOptions.length);
            for (int i = 0; i < partnerOptions.length; i++) {
                int index = (start + i) % partnerOptions.length;
                Cell potentialPartner = partnerOptions[index];
                if (partnerOptions[index].partner != null) {
                    partner = potentialPartner;
                    partnerOptions[index].partner = this;
                    break;
                }
            }
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // observer neighbors' states
    public abstract Color getColor();
    public abstract int getStatus();
    public abstract int getAmbience();
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);

}
