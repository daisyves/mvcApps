package CALab;
import mvc.*;
public abstract class GridFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model m);

    @Override
    public String getTitle() {
        return "CA LAB";
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return "CA Lab Program";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"RUN1", "RUN50", "POPULATE", "CLEAR"};
    }
    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "RUN1":
                return new UpdateLoop(model, 1);
            case "RUN50":
                return new UpdateLoop(model, 50);
            case "POPULATE":
                return new Populate(model);
            case "CLEAR":
                return new Clear(model);
        }
        return null;
    }
}
