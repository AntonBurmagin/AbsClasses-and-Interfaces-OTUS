package project.src.factory;
import project.src.animals.AbsAnimal;
import project.src.animals.birds.Duck;
import project.src.animals.pets.Cat;
import project.src.animals.pets.Dog;
import project.src.data.AnimalTypes;

public class Factory {
    public AbsAnimal create(AnimalTypes type) {
        return switch (type) {
            case CAT -> new Cat();
            case DOG -> new Dog();
            case DUCK -> new Duck();
        };
    }
}
