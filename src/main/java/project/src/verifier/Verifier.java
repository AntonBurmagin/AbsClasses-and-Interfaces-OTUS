package project.src.verifier;

import project.src.data.AnimalType;
import project.src.data.ColorType;

import java.util.Arrays;

public class Verifier {
    public boolean animalTypeVerifier(String animalType) {
        if (AnimalType.values().toString().contains(animalType.trim().toUpperCase())) {
            return true;
        }
        System.out.println("Incorrect animal type!");
        return false;
    }

    public boolean colorVerifier(String color) {
        if (ColorType.values().toString().contains(color.trim().toUpperCase())) {
            return true;
        }
        System.out.println("Incorrect color! Choose one of " + Arrays.toString(ColorType.values()));
        return false;
    }

    public boolean nameVerifier(String name) {
        char[] nameArr = name.toLowerCase().toCharArray();
        for (char letter : nameArr) {
            if (!((letter >= 'a' && letter <= 'z') || (letter >= 'а' && letter <= 'я')))
                return false;
        }
        System.out.println("Incorrect name format! Name should contain only letters (English or Russian)!");
        return true;
    }

    public boolean ageVerifier(Object age) {
        if (age instanceof Integer) {
            if ((int)age > 0 && (int)age < 31)
                return true;
        }
        System.out.println("Incorrect age format! It must be Integer from 1 to 30!");
        return false;
    }

    public boolean weightVerifier(Object weight) {
        if (weight instanceof Double) {
            if ((double)weight > 0 && (double)weight < 156)
                return true;
        }
        System.out.println("Incorrect weight format! It must be Double from 0+ to 155 kg (world record for dogs)!");
        return false;
    }
}
