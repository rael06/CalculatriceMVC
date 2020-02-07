import controller.Controlleur;
import model.Calculateur;
import view.Console;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Calculateur.getInstance().addObserver(Console.getInstance());
        Calculateur.getInstance().addObserver(MainFrame.getInstance());
        MainFrame.getInstance().start();
    }
}
