package project.src;
import project.src.animals.AbsAnimal;
import project.src.data.AnimalType;
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
        AbsAnimal pet1 = factory.create(AnimalType.DOG);

        String order;
        OrderType orderType = null;
        //AbsAnimal animal = factory.create(AnimalTypes.DOG);

        while (true) {
            System.out.println("What's your command " + Arrays.toString(OrderType.values()));
            Scanner input = new Scanner(System.in);
            order = input.nextLine().trim().toUpperCase();
            System.out.println(order);
            if (order.equals(OrderType.EXIT.toString())) {
                System.out.println("Got exit. Goodbye!");
                break;
            } else if (order.equals(OrderType.ADD.toString())) {
                Verifier verifier = new Verifier();
                String type;
                String name;
                Integer age;
                Double weight;
                String color;
                while (true) {
                    System.out.println("Input animal type " + Arrays.toString(AnimalType.values()));
                    type = input.nextLine().trim().toUpperCase();
                    if (verifier.animalTypeVerifier(order))
                        break;
                }

                while (true) {
                    System.out.printf("Input %s name:\n", type);
                    name = input.nextLine().trim();
                    if (verifier.nameVerifier(name))
                        break;
                }

                while (true) {
                    System.out.printf("Input %s age:\n", type);
                    age = Integer.valueOf(input.nextLine().trim());
                    if (verifier.ageVerifier(age))
                        break;
                }

                while (true) {
                    System.out.printf("Input %s weight:\n", type);
                    weight = Double.valueOf(input.nextLine().trim());
                    if (verifier.weightVerifier(weight))
                        break;
                }

                while (true) {
                    System.out.printf("Input %s color:\n", type);
                    color = input.nextLine().trim();
                    if (verifier.colorVerifier(color))
                        break;
                }

                AbsAnimal newbornAnimal = factory.create(AnimalType.valueOf(type));
                newbornAnimal.setName(name);
                newbornAnimal.setAge(age);
                newbornAnimal.setWeight(weight);
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