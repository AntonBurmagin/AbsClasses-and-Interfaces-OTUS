package project.src.Animals.Birds;

import project.src.Animals.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying {

    void say() {
        System.out.println("QUACK!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
