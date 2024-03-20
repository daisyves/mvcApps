package life;

import CALab.*;
import mvc.*;

public class lifeFactory extends GridFactory {
    @Override
    public Model makeModel() { return new Society(); }

    @Override
    public View makeView(Model m) {
        return new GridView((Society)m);
    }

    @Override
    public String getTitle() {	return "Life Lab"; }

    @Override
    public String about() {
        return "Life Lab using CALab and MVC framework.\n By Nay, Liza, Daisy";
    }
}
