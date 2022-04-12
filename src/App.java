
import Controller.Controller;
import Model.*;
import View.View;

public class App
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }

}
