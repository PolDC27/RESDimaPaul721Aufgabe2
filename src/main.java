import console.Console;
import controller.Controller;
import model.Produkt;
import model.Charakter;
import repository.Repo;
import repository.Repository;

import java.text.ParseException;

public class main {
    public static void main(String[] args) throws ParseException {
        Repository<Produkt> models1 = new Repo<>();
        Repository<Charakter> models2 = new Repo<>();
        Controller controller = new Controller(models1, models2);
        Console console = new Console(controller);

        while (true){
            console.run();
        }

    }
}
