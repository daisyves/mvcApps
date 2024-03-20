package life;

import java.awt.Color;
import java.util.Iterator;

import CALab.Cell;

public class Agent extends Cell {
    private int status;
    private int ambience;

    public Agent() {
        this(true);
    }

    public Agent(boolean dead) {
        if (dead) {
            status = 0;
        } else {
            status = 1;
        }
        ambience = 0;
    }
    @Override
    public int getAmbience() {
        return ambience;
    }

    @Override
    public void observe() {
        int sum = 0;
        Iterator<Cell> it = super.neighbors.iterator();
        while (it.hasNext()) {
            Cell c = it.next();
            if (c.getStatus() == 1) {
                sum++;
            }
        }
        ambience = sum;
    }

    @Override
    public void update() {
        if (status == 1) {
            if (Society.death.contains(ambience))
                status = 0;
        } else {
            if (Society.rebirth.contains(ambience))
                status = 1;
        }
    }

    @Override
    public void interact() {}
    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            status = (int) (Math.random() * 2);
        } else {
            status = 0;
            ambience = 0;
        }
    }
    @Override
    public void nextState() {
        if (status == 0) {
            status = 1;
        } else {
            status = 0;
        }
    }
    @Override
    public int getStatus() {
        return status;
    }


    @Override
    public Color getColor() {
        if (this.status == 0) {
            return new Color(255, 0, 0);
        } else {
            return new Color(0, 255, 0);
        }
    }
}
