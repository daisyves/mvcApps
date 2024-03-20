package CALab;

import java.util.HashSet;
import java.util.Set;

import mvc.Model;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() {
        return dim;
    }

    public int getTime() {
        return time;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public abstract Cell makeCell(boolean uniform);

    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }

    public Grid() {
        this(20);
    }

    protected void populate() {
        // 1. use makeCell to fill in cells
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell cell = makeCell(false);
                cells[i][j] = cell;
            }
        }
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].neighbors = getNeighbors(cells[i][j], 1);
            }
        }
        repopulate(true);
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        // randomly set status of each cell
        if (randomly) {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    cells[i][j].reset(true);
                }
            }
            // set the status of each cell to 0 (dead)
        } else {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    cells[i][j].reset(false);
                }
            }
        }
        // notify subscribers
        changed();
    }

    public Set<Cell> getNeighbors(Cell asker, int radius) {
        Set<Cell> neighbors = new HashSet<Cell>();
        if (asker == null || radius <= 0) {
            return neighbors;
        }
        int row = asker.row;
        int col = asker.col;

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                int newRow = (row + i + dim) % dim;
                int newCol = (col + j + dim) % dim;
                if (newRow != row || newCol != col) {
                    neighbors.add(cells[newRow][newCol]);
                }
            }
        }
        return neighbors;
    }

    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int row = 0; row < dim; row++) {
            for (int j = 0; j < dim; j++) {
                cells[row][j].neighbors = getNeighbors(cells[row][j], 1);
                cells[row][j].observe();
            }
        }

        changed();
    }

    public void interact() {
        // call each cell's interact method
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].interact();
            }
        }
        changed();
    }

    public void update() {
        // call each cell's update method and notify subscribers
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].update();
            }
        }
        changed();
    }

    public void updateLoop(int cycles) {
        observe();
        for (int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}
