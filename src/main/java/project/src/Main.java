package project.src;
import project.src.animals.AbsAnimal;
import project.src.data.AnimalType;
import project.src.data.ColorType;
import project.src.data.OrderType;
import project.src.db.dbconnectors.MySQLConnector;
import project.src.db.table.AnimalTable;
import project.src.factory.Factory;
import project.src.verifier.Verifier;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws SQLException {
        Factory factory = new Factory();
        String order;

        MySQLConnector connector = new MySQLConnector();
        AnimalTable table = new AnimalTable(connector);
        if (!table.exist())
            table.create(table.getInitColumns());

//        AbsAnimal bob = factory.create(AnimalType.DOG);
//        bob.setColor("black");
//        System.out.println(bob.getColor());


        while (true) {
            System.out.printf("What's your command (%s)\n", OrderType.getAvailableOrders());
            Scanner input = new Scanner(System.in);
            order = input.nextLine().trim().toUpperCase();
            try{
                String id = "";
                Verifier verifier = new Verifier();
                switch (order) {
                    case ("EXIT"):
                        System.out.println("Goodbye!");
                        System.exit(0);

                    case ("UPDATE"):
                        do {
                            System.out.printf("Input animal id you want to update\n");
                            id = input.nextLine().toUpperCase();
                        } while (!verifier.idVerifier(id));

                    case ("ADD"):
                        String type;
                        String name;
                        String age;
                        String weight;
                        String color;

                        do {
                            System.out.printf("Input animal type (%s)\n",
                                    Arrays.stream(AnimalType.values()).map(command -> command.name().toLowerCase()).collect(Collectors.joining("/")));
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
                            System.out.printf("One of these (%s)\n",
                                    Arrays.stream(ColorType.values()).map(command -> command.name().toLowerCase()).collect(Collectors.joining("/")));
                            color = input.nextLine().trim();
                        } while (!verifier.colorVerifier(color));

                        AbsAnimal newbornAnimal = factory.create(AnimalType.valueOf(type));
                        newbornAnimal.setName(name);
                        newbornAnimal.setAge(Integer.valueOf(age));
                        newbornAnimal.setWeight(Float.valueOf(weight));
                        newbornAnimal.setColor(color);

                        if (order.equals("UPDATE")) {
                            table.update(Integer.parseInt(id), newbornAnimal, AnimalType.valueOf(type));
                            break;
                        }


                        table.insert(newbornAnimal, AnimalType.valueOf(type));
                        break;


                    case ("LIST"):
                        if (table.isEmpty()) {
                            System.out.println("Your list is empty! Try " + OrderType.ADD.toString() + " first!");
                            continue;
                        }

                        System.out.printf("Input animal type or anything else if type doesn't matter(%s)\n",
                                Arrays.stream(AnimalType.values()).map(command -> command.name().toLowerCase()).collect(Collectors.joining("/")));
                        String selectedType = input.nextLine().toUpperCase();

                        ArrayList<String> predicatesList = new ArrayList<>();
                        if (AnimalType.isAnimalType(selectedType))
                            predicatesList.add(String.format("type='%s'",selectedType.toLowerCase()));

                        String []predicates = new String[predicatesList.size()];
                        predicates = predicatesList.toArray(predicates);

                        ResultSet requestResult = table.select(table.getColumnsNames(), predicates);

                        ArrayList<AbsAnimal> animals = new ArrayList<>();
                        while(requestResult.next()) {
                            AbsAnimal nextAnimal = factory.create(AnimalType.valueOf(requestResult.getString("type").toUpperCase()));
                            nextAnimal.setName(requestResult.getString("name"));
                            nextAnimal.setAge(Integer.valueOf(requestResult.getString("age")));
                            nextAnimal.setWeight(Float.valueOf(requestResult.getString("weight")));
                            nextAnimal.setColor(requestResult.getString("color"));
                            animals.add(nextAnimal);
                        }

                        for (AbsAnimal iterator : animals) {
                            System.out.println(iterator.toString());
                        }
                        break;


                    case ("CLEAR"):
                        table.clear();
                        break;






                    default:
                        System.out.printf("%s command doesn't exist!\n", order);
                }
            } finally {
                connector.close();
            }


        }
    }
}