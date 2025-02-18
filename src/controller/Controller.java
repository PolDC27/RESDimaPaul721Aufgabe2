package controller;

import model.Produkt;
import model.Charakter;
import repository.Repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {
    private final Repository<Produkt> model1Repository;
    private final Repository<Charakter> model2Repository;

    public Controller(Repository<Produkt> model1Repository, Repository<Charakter> model2Repository) {
        this.model1Repository = model1Repository;
        this.model2Repository = model2Repository;
    }


    /**
     * The method asks for input to determine which model1 from the model1Repo to add to a list.
     * It also asks the quantity to be added
     * @return a list of Model1 instances
     */
    public List<Produkt> createModel1List() {
        Scanner sc = new Scanner(System.in);
        List<Produkt> produktList = new ArrayList<>();
        while (true) {
            System.out.println("Enter Model1 number: ");
            int model1Number = sc.nextInt();
            sc.nextLine();
            if (model1Number < 0 || model1Number > model1Repository.getAll().size()) {
                break;
            }

            System.out.println("Enter model1 quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= quantity; i++) {
                produktList.add(getAllModel1().get(model1Number));
            }
        }
        return produktList;
    }

    /**
     * Creates a new Model1 object and ads it to the model1 repository
     * @throws ParseException
     */
    public void createModel1() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model1 atr1: ");
        String model1String = sc.nextLine();
        System.out.println("Enter Model1 atr2: ");
        Double model1Double = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Model1 atr3: ");
        String model1Date = sc.nextLine();



        model1Repository.create(new Produkt(model1String, model1Double, model1Date));

    }

    /**
     * Deletes a model1 from the repository if it exists
     */
    public void deleteModel1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model1 atr1: ");
        String model1String = sc.nextLine();
        for (Produkt produkt : model1Repository.getAll()) {
            if (produkt.getName().equals(model1String)) {
                model1Repository.delete(produkt);
                System.out.println("Deleted Successfully");
                break;
            }
        }
    }

    /**
     * Searches based of the first attribute for a model1 in the model1 repository
     * @param string the attribute that is used to identify the searched object
     * @return a Model1 object
     */
    public Produkt getModel1(String string) {
        for (Produkt produkt : model1Repository.getAll()) {
            if (produkt.getName().equals(string)) {
                return model1Repository.get(produkt);
            }
        }
        return null;
    }

    /**
     * Finds a Model1 object and changes its attributes with the new given ones and updates the repository
     * @throws ParseException
     */
    public void updateModel1() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model1 atr1: ");
        String model1String = sc.nextLine();

        if (getModel1(model1String) != null) {
            System.out.println("Enter new Model1 atr2: ");
            Double model1Double = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter Model1 atr3: ");
            String model1Date = sc.nextLine();

            model1Repository.update(getModel1(model1String), new Produkt(model1String, model1Double, model1Date));
        }

    }


    public List<Produkt> getAllModel1() {
        return model1Repository.getAll();
    }

    /**
     * Creates a new Model2 object based on the user input and adds it to the repository
     * @throws ParseException
     */
    public void createModel2() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model2 atr1: ");
        int model2Int = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Model2 atr2: ");
        String model2String1 = sc.nextLine();
        System.out.println("Enter Model2 atr3: ");
        String model2String2 = sc.nextLine();

        for (int i = 0; i < model1Repository.getAll().size(); i++) {
            System.out.println(i + "." + model1Repository.getAll().get(i));
        }

        model2Repository.create(new Charakter(model2Int, model2String1, model2String2, createModel1List()));

    }

    /**
     * Deletes a model2 object from the repository if it exists searched by the first attribute
     */
    public void deleteModel2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model2 atr1: ");
        int model2Int = sc.nextInt();
        sc.nextLine();
        for (Charakter charakter : model2Repository.getAll()) {
            if (charakter.getId() == model2Int) {
                model2Repository.delete(charakter);
                System.out.println("Deleted Successfully");
                break;
            }
        }
    }

    /**
     * Searches for a Model2 object in the repository by the first attribute
     * @param value
     * @return a Model2 type object
     */
    public Charakter getModel2(int value) {
        for (Charakter charakter : model2Repository.getAll()) {
            if (charakter.getId() == value) {
                return model2Repository.get(charakter);
            }
        }
        return null;
    }

    /**
     * Finds a Model2 object and changes its attributes with the new given ones and updates the repository
     */
    public void updateModel2()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model2 atr1: ");
        int model2Int = sc.nextInt();
        sc.nextLine();
        if (getModel2(model2Int) != null) {
            System.out.println("Enter Model2 atr2: ");
            String model2String1 = sc.nextLine();
            System.out.println("Enter Model2 atr3: ");
            String model2String2 = sc.nextLine();
            model2Repository.update(getModel2(model2Int), new Charakter(model2Int, model2String1, model2String2, createModel1List()));
        }
    }

    public List<Charakter> getAllModel2() {
        return model2Repository.getAll();
    }

    /**
     *
     * @return
     */
    public Produkt filterCharakters(){return null;}

    /**
     *
     * @return
     */
    public Produkt ex2(){return null;}

    /**
     *
     * @return
     */

    public Produkt ex3(){return null;}



}
