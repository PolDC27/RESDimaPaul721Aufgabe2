package controller;

import model.Produkt;
import model.Charakter;
import repository.Repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {
    private final Repository<Produkt> produktRepository;
    private final Repository<Charakter> charakterRepository;

    public Controller(Repository<Produkt> produktRepository, Repository<Charakter> charakterRepository) {
        this.produktRepository = produktRepository;
        this.charakterRepository = charakterRepository;
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
            if (model1Number < 0 || model1Number > produktRepository.getAll().size()) {
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



        produktRepository.create(new Produkt(model1String, model1Double, model1Date));

    }

    /**
     * Deletes a model1 from the repository if it exists
     */
    public void deleteModel1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model1 atr1: ");
        String model1String = sc.nextLine();
        for (Produkt produkt : produktRepository.getAll()) {
            if (produkt.getName().equals(model1String)) {
                produktRepository.delete(produkt);
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
        for (Produkt produkt : produktRepository.getAll()) {
            if (produkt.getName().equals(string)) {
                return produktRepository.get(produkt);
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

            produktRepository.update(getModel1(model1String), new Produkt(model1String, model1Double, model1Date));
        }

    }


    public List<Produkt> getAllModel1() {
        return produktRepository.getAll();
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

        for (int i = 0; i < produktRepository.getAll().size(); i++) {
            System.out.println(i + "." + produktRepository.getAll().get(i));
        }

        charakterRepository.create(new Charakter(model2Int, model2String1, model2String2, createModel1List()));

    }

    /**
     * Deletes a model2 object from the repository if it exists searched by the first attribute
     */
    public void deleteModel2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model2 atr1: ");
        int model2Int = sc.nextInt();
        sc.nextLine();
        for (Charakter charakter : charakterRepository.getAll()) {
            if (charakter.getId() == model2Int) {
                charakterRepository.delete(charakter);
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
        for (Charakter charakter : charakterRepository.getAll()) {
            if (charakter.getId() == value) {
                return charakterRepository.get(charakter);
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
            charakterRepository.update(getModel2(model2Int), new Charakter(model2Int, model2String1, model2String2, createModel1List()));
        }
    }

    public List<Charakter> getAllModel2() {
        return charakterRepository.getAll();
    }

    /**
     *
     * @return a list of charakters based on a herkunftsort
     */
    public List<String> filterCharakters(String herkunftsort){
        List<String> charakterList = new ArrayList<>();
        for (Charakter charakter : charakterRepository.getAll()) {
            if (herkunftsort.equals(charakter.getHerkunftdorf())) {
                charakterList.add(charakter.getName());
            }
        }
        return charakterList;
    }

    /**
     *
     * @return filters charakters that have at least a produkt with a specific herkunftsregion sorted alphabetically
     */
    public List<String> filterCharaktersByProdukts(String herkunftsregion){
        List<String> charakterList = new ArrayList<>();
        for (Charakter charakter : charakterRepository.getAll()) {
            for (Produkt produkt : charakter.getModel1s()){
                if (produkt.getHerkunftsregion().equals(herkunftsregion) ) {
                    charakterList.add(charakter.getName());
                    break;
                }
            }
        }
        for (int i = 0; i < charakterList.size() - 1; i++) {
            for (int j = i + 1; j < charakterList.size(); j++) {
                if (charakterList.get(i).charAt(0) > charakterList.get(j).charAt(0)) {
                    String temp = charakterList.get(i);
                    charakterList.set(i, charakterList.get(j));
                    charakterList.set(j, temp);
                }
            }
        }
        return charakterList;
    }

    /**
     *
     * @return
     */

    public List<Produkt> ex3(int id, String sortType){
        for ()
    }



}
