package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Animal animal = new Animal();
//        animal.setName("Bob");
//        animal.setAge(11);
//        animal.setWeight(18.5f);
//        animal.setColor("Pink");
//        System.out.println(animal.toString());
        String order;
        Order orderType = null;
        System.out.println(orderType.EXIT.toString());
        while (true) {
            System.out.println("What's your command (add, list, exit):");
            Scanner input = new Scanner(System.in);
            order = input.nextLine().trim().toUpperCase();
            System.out.println(order);
            if (order.equals(orderType.EXIT.toString())) {
                System.out.println("Got exit. Goodbye!");
                break;
            } else if (order.equals(orderType.ADD.toString())) {
                System.out.println("Got add");
            } else if (order.equals(orderType.LIST.toString())) {
                System.out.println("Got list");
            } else {
                System.out.println("Got nothing");
            }



        }
    }
}