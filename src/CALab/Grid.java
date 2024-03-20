package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;
import java.util.ArrayList;


public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        for(int i = 0; i < getDim(); i++) {
            for (int j = 0; i < getDim(); j++) {
                // 1. use makeCell to fill in cells
                this.makeCell(Math.random() < 0.5);
                // 2. use getNeighbors to set the neighbors field of each cell
                this.getNeighbors(getCell(i,j), 1); // radius can change depending on project?
            }
        }
        changed();
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        if (randomly) {
            // randomly set the status of each cell
            for(int i = 0; i < dim; i++) {
                for (int j = 0; i < dim; j++) {
                    cells[i][j].reset(randomly); // unsure about this part
                }
            }
        } else {
            // set the status of each cell to 0 (dead)
            for(int i = 0; i < dim; i++) {
                for (int j = 0; i < dim; j++) {
                    getCell(i,j).reset(true); // and this
                }
            }
        }
        // notify subscribers
        changed();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        int dim = getDim();

        Set<Cell> neighbors = new HashSet<Cell>();
        int[][] neighborMatrix = new int[][]{
                {-radius, -radius}, {-radius, 0}, {-radius, radius},
                {0, -radius}, {0, radius},
                {radius, -radius}, {radius, 0}, {radius, radius}
        };

        for(int[] nm : neighborMatrix){
            int rows = (asker.row + nm[0] + dim) % dim;
            int cols = (asker.col + nm[1] + dim) % dim;
            neighbors.add(cells[rows][cols]);
        }


        return neighbors;
    }

    // overide these
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }

    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for(int i = 0; i < dim; i++) {
            for (int j = 0; i < dim; j++) {
                cells[i][j].observe();
            }
        }
    }

    public void interact() {
        for(int i = 0; i < dim; i++) {
            for (int j = 0; i < dim; j++) {
                cells[i][j].interact();
            }
        }
    }

    public void update() {
        for(int i = 0; i < dim; i++) {
            for (int j = 0; i < dim; j++) {
                cells[i][j].update();
            }
        }
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}
