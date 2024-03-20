package CALab;

import mvc.*;
public class RunCommand extends Command {
    public String runNum;
    public RunCommand(Model model) {
        super(model);
        runNum = null;
    }

    public void execute() {
        Grid grid = (Grid)model;
        if (runNum.equals("RUN1")) {
            grid.updateLoop(1);
        } else if (runNum.equals("RUN50")) {
            grid.updateLoop(50);
        }
    }
}