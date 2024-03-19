package mvc;

public interface AppFactory {

    public Model makeModel();
    public View makeView(Model m);
    public String getTitle();
    public String[] getHelp();
    public String about();
    public String[] getEditCommands();

   /* unsure about this, uml shows as the class only
   having (String name) as a parameter but StopLightFactory
   shows (Model model, String type, Object source) */
    //public Command makeEditCommand(String name);
   public Command makeEditCommand(Model model, String type, Object source);

}
