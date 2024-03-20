package CALab;
import mvc.*;

public class ClearCommand extends Command {
    public ClearCommand(Model model) {
        super(model);
    }

    public void execute() {
        Grid grid = (Grid)model;
        grid.repopulate(false);
    }
}
