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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Factory factory = new Factory();
        ArrayList<AbsAnimal> animal = new ArrayList<AbsAnimal>();
        String order;

        MySQLConnector connector = new MySQLConnector();
        AnimalTable table = new AnimalTable(connector);
        if (!table.exist())
            table.create(table.getColumns());


//        String query = "SELECT * from animal;";

        //выполнить запрос
//        ResultSet resSet = connector.executeQuery(query);
        // вывести заголовки таблицы на экран
//        System.out.printf("%-5s %-10s %-5s %-8s %-10s %-10s%n", "id", "color", "name", "weight", "type", "age");
//        System.out.println("---------------------------------------------------");

        // вывести ответ от БД в виде таблицы
//        while (resSet.next()) {
//            System.out.printf("%-5s %-10s %-5s %-8s %-10s %-10s%n",
//                    resSet.getString("id"),
//                    resSet.getString("color"),
//                    resSet.getString("name"),
//                    resSet.getString("weight"),
//                    resSet.getString("type"),
//                    resSet.getString("age"));
//        }



        while (true) {
            System.out.printf("What's your command (%s)\n", OrderType.getAvailableOrders());
            Scanner input = new Scanner(System.in);
            order = input.nextLine().trim().toUpperCase();
            try{
                switch (order) {
                    case ("EXIT"):
                        System.out.println("Goodbye!");
                        System.exit(0);

                    case ("ADD"):
                        Verifier verifier = new Verifier();
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

                        animal.addLast(newbornAnimal);
                        newbornAnimal.say();
                        break;

                    case ("LIST"):
                        if (animal.isEmpty()) {
                            System.out.println("Your list is empty! Try " + OrderType.ADD.toString() + " first!");
                            continue;
                        }
                        for (AbsAnimal iterator : animal) {
                            System.out.println(iterator.toString());
                        }
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