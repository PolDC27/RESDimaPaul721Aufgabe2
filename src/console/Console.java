package console;

import controller.Controller;

import java.text.ParseException;
import java.util.Scanner;

public class Console {
    private final Controller controller;


    public Console(Controller controller) {
        this.controller = controller;
    }

    /**
     * @return a given int input from the user
     */
    public int takeIntChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number you would like to take: ");
        return scanner.nextInt();
    }

    /**
     * @return a given String input from the user
     */
    public String takeStringChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number you would like to take: ");
        return scanner.nextLine();
    }


    /**
     * The manu that appears on the screen that takes the user input and based on that chooses which methods to use
     * @throws ParseException
     */
    public void run() throws ParseException {
        while (true) {
            System.out.println("Welcome to the app");
            System.out.println("""
                    1. Add a new product
                    2. Remove a product
                    3. Show all products
                    4. Update a product
                    5. Show specific products
                    6. Add a new customer
                    7. Remove a customer
                    8. Show all customers
                    9. Update a customer
                    10. Show specific customers
                    11. Ex1
                    12. Ex2
                    13. Ex3
                   
                    """);

            int choice = takeIntChoice();
            switch (choice) {
                case 1:
                    controller.createModel1();
                    break;

                case 2:
                    controller.deleteModel1();
                    break;

                case 3:
                    System.out.println(controller.getAllModel1());
                    break;

                case 4:
                    controller.updateModel1();
                    break;
                case 5:
                    System.out.println(controller.getModel1(takeStringChoice()));
                    break;
                case 6:
                    controller.createModel2();
                    break;

                case 7:
                    controller.deleteModel2();
                    break;

                case 8:
                    System.out.println(controller.getAllModel2());
                    break;

                case 9:
                    controller.updateModel2();
                    break;

                case 10:
                    System.out.println(controller.getModel2(takeIntChoice()));
                    break;

                case 11:
                    System.out.println(controller.filterCharakters(takeStringChoice()));
                    break;

                case 12:
                    System.out.println(controller.ex2());
                    break;

                case 13:
                    System.out.println(controller.ex3());
                    break;
            }
        }

    }
}
