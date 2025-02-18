import console.Console;
import controller.Controller;
import model.Produkt;
import model.Charakter;
import repository.Repo;
import repository.Repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws ParseException {
        Repository<Produkt> produkte = new Repo<>();
        Repository<Charakter> charakters = new Repo<>();
        produkte.create(new Produkt("Kunai", 50.0, "Konoha"));
        produkte.create(new Produkt("Shuriken", 30.0, "Konoha"));
        produkte.create(new Produkt("Schwert", 200.0, "Kirigakure"));
        produkte.create(new Produkt("Heiltrank", 100.0, "Sunagakure"));
        produkte.create(new Produkt("Sprengsiegel", 75.0, "Iwagakure"));
        produkte.create(new Produkt("Riesenfächer", 300.0, "Sunagakure"));
        produkte.create(new Produkt("Giftklinge", 150.0, "Kirigakure"));
        produkte.create(new Produkt("Explosionskugel", 250.0, "Iwagakure"));
        produkte.create(new Produkt("Schattendolch", 180.0, "Konoha"));
        produkte.create(new Produkt("Wasserperle", 90.0, "Kirigakure"));

        List<Produkt> c1List = new ArrayList<>();
        List<Produkt> c2List = new ArrayList<>();
        List<Produkt> c3List = new ArrayList<>();
        List<Produkt> c4List = new ArrayList<>();
        List<Produkt> c5List = new ArrayList<>();

        Controller controller = new Controller(produkte, charakters);
        Console console = new Console(controller);

        c1List.add(controller.getModel1("Kunai"));
        c1List.add(controller.getModel1("Heitrank"));
        c1List.add(controller.getModel1("Schattendolch"));
        c1List.add(controller.getModel1("Riesenfacher"));

        c2List.add(controller.getModel1("Schwert"));
        c2List.add(controller.getModel1("Sprengsiegel"));
        c2List.add(controller.getModel1("Giftklinge"));
        c2List.add(controller.getModel1("Shuriken"));

        c3List.add(controller.getModel1("Shuriken"));
        c3List.add(controller.getModel1("Schwert"));
        c3List.add(controller.getModel1("Heiltrank"));
        c3List.add(controller.getModel1("Explosionskugel"));
        c3List.add(controller.getModel1("Wasserperle"));

        c4List.add(controller.getModel1("Kunai"));
        c4List.add(controller.getModel1("Sprengsiegel"));
        c4List.add(controller.getModel1("Explosionskugel"));
        c4List.add(controller.getModel1("Wasserperle"));

        c5List.add(controller.getModel1("Schattendolch"));
        c5List.add(controller.getModel1("Giftklinge"));
        c5List.add(controller.getModel1("Schwert"));
        c5List.add(controller.getModel1("Explosionskugel"));


        Charakter c1 = new Charakter(1, "Naruto Uzumaki", "Konoha",c1List );
        Charakter c2 = new Charakter(2, "Gaara", "Sunagakure", c2List);
        Charakter c3 = new Charakter(3, "Kisame Hoshigaki", "Kirigakure", c3List);
        Charakter c4 = new Charakter(4, "Deidara", "Iwagakure", c4List);
        Charakter c5 = new Charakter(5, "Itachi Uchiha", "Konoha", c5List);

        charakters.create(c1);
        charakters.create(c2);
        charakters.create(c3);
        charakters.create(c4);
        charakters.create(c5);


        while (true){
            console.run();
        }

    }
}
