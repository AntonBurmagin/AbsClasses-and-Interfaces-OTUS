package org.example;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setName("Bob");
        animal.setAge(11);
        animal.setWeight(18.5f);
        animal.setColor("Pink");
        System.out.println(animal.toString());

    }
}