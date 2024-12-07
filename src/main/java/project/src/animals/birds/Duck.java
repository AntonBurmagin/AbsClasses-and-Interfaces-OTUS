package project.src.animals.birds;

import project.src.animals.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying {

    public void say() {
        System.out.println("QUACK!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
