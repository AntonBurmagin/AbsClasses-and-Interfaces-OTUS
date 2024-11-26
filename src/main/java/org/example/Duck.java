package org.example;

public class Duck extends Animal implements Flying {

    void say() {
        System.out.println("QUACK!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
