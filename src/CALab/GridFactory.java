package CALab;

import mvc.*;
public abstract class GridFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model model);

    @Override
    public String getTitle() {
        return "CA Lab";
    }

    @Override
    public String[] getHelp() {
        // Implement this method
        return new String[] {"Click on cell squares to toggle state",
                "RUN1 = progress simulation by 1",
                "RUN50 = progress simulation by 50",
                "POPULATE = Randomly populate grid",
                "CLEAR = Clear grid"};
    }

    @Override
    public String about() {
        return "CA Lab";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"RUN1", "RUN50", "POPULATE", "CLEAR"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        Command command = null;
        if (type.equals("RUN1")) {
            command = new RunCommand(model);
            ((RunCommand)command).runNum = type;
        }
        else if (type.equals("RUN50")) {
            command = new RunCommand(model);
            ((RunCommand)command).runNum = type;
        }
        else if (type.equals("POPULATE")) {
            command = new PopulateCommand(model);
        }
        else if (type.equals("CLEAR")) {
            command = new ClearCommand(model);
        }
        return command;
    }
}
