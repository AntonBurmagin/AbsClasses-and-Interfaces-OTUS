package project.src;
import project.src.animals.AbsAnimal;
import project.src.data.AnimalTypes;
import project.src.factory.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        ArrayList<AbsAnimal> animal = new ArrayList<AbsAnimal>();
        AbsAnimal pet1 = factory.create(AnimalTypes.DOG);

        String order;
        Order orderType = null;
        //AbsAnimal animal = factory.create(AnimalTypes.DOG);

        while (true) {
            System.out.println("What's your command " + Arrays.toString(Order.values()) + ":");
            Scanner input = new Scanner(System.in);
            order = input.nextLine().trim().toUpperCase();
            System.out.println(order);
            if (order.equals(Order.EXIT.toString())) {
                System.out.println("Got exit. Goodbye!");
                break;
            } else if (order.equals(Order.ADD.toString())) {
                System.out.println("Got add");
            } else if (order.equals(Order.LIST.toString())) {
                if (animal.isEmpty()) {
                    System.out.println("Your list is empty! Try " + Order.ADD.toString() + " first!");
                    continue;
                }
                for (AbsAnimal iterator : animal) {
                    System.out.println(iterator.toString());
                }
            } else {
                System.out.printf("%s command doesn't exist!\n", order);
            }
        }
    }
}