package CALab;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView[][] cellViews;

    public GridView(Model model) {
        super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
        int dim = ((Grid)model).getDim();
        cellViews = new CellView[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell cell = ((Grid)model).getCell(i, j);
                cellViews[i][j] = new CellView(cell);
                cell.row = i;
                cell.col = j;
            }
        }
        this.setLayout(new GridLayout(dim, dim));
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim ; j++) {
                this.add(cellViews[i][j]);
            }
        }
    }

    public void update() {
        // call update method of each CellView
        for (int i = 0; i < cellViews.length; i++) {
            for (int j = 0; j < cellViews[0].length; j++) {
                cellViews[i][j].update();
            }
        }
    }

}