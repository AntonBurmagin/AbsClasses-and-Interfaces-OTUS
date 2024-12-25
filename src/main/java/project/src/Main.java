package project.src;
import project.src.animals.AbsAnimal;
import project.src.data.AnimalType;
import project.src.data.ColorType;
import project.src.data.OrderType;
import project.src.factory.Factory;
import project.src.verifier.Verifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        ArrayList<AbsAnimal> animal = new ArrayList<AbsAnimal>();
        String order;

        while (true) {
            System.out.println("What's your command " + Arrays.toString(OrderType.values()));
            Scanner input = new Scanner(System.in);
            order = input.nextLine().trim().toUpperCase();
            if (order.equals(OrderType.EXIT.toString())) {
                System.out.println("Goodbye!");
                break;
            } else if (order.equals(OrderType.ADD.toString())) {
                Verifier verifier = new Verifier();
                String type;
                String name;
                String age;
                String weight;
                String color;

                do {
                    System.out.println("Input animal type " + Arrays.toString(AnimalType.values()));
                    type = input.nextLine().toUpperCase();
                } while (!verifier.animalTypeVerifier(type));

                do {
                    verifier.commonPrintf("name", type);
                    name = input.nextLine().trim();
                } while (!verifier.nameVerifier(name));

                do {
                    verifier.commonPrintf("age", type);
                    age = input.nextLine().trim();
                } while (!verifier.ageVerifier(age));

                do {
                    verifier.commonPrintf("weight", type);
                    weight = input.nextLine().trim();
                } while (!verifier.weightVerifier(weight));

                do {
                    verifier.commonPrintf("color", type);
                    System.out.println("One of these "+ Arrays.toString(ColorType.values()));
                    color = input.nextLine().trim();
                } while (!verifier.colorVerifier(color));

                AbsAnimal newbornAnimal = factory.create(AnimalType.valueOf(type));
                newbornAnimal.setName(name);
                newbornAnimal.setAge(Integer.valueOf(age));
                newbornAnimal.setWeight(Double.valueOf(weight));
                newbornAnimal.setColor(color);

                animal.addLast(newbornAnimal);
                newbornAnimal.say();

            } else if (order.equals(OrderType.LIST.toString())) {
                if (animal.isEmpty()) {
                    System.out.println("Your list is empty! Try " + OrderType.ADD.toString() + " first!");
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