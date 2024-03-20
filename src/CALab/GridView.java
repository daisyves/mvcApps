package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

/* From CALab webpage
The presentation layer of CALab is similar to the model layer.
A GridView consists of an NxN grid of CellViews.
The GridView’s model is the Grid and each CellView is associated with one Cell.
 */

public class GridView  extends View {

    private CellView cellViews[][];

    public GridView(Model model) {

        //Given:
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */

        super(model);
        Grid g = (Grid) model;
        int dim = g.getDim();
        cellViews = new CellView[dim][dim];

        this.setLayout(new GridLayout(dim, dim));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        // i = rows, j = columns
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++) {
                //different from given code, was giving error due to type, so I changed it
                CellView cell = new CellView(g.getCell(i,j));
                cellViews[i][j] = cell;

                this.add(cell); //add cellViews to grid?
            }
        }
    }
    public void update(String msg, Object oldState, Object newState) {
        // call update method of each CellView
        Grid g = (Grid) model;
        int dim = g.getDim();

        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++) {
                cellViews[i][j].update(); // unsure what to do with the parameters msg, oldSate, newState?
            }
        }

    }

}