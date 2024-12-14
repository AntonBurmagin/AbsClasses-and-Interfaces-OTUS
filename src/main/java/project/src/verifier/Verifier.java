package project.src.verifier;
import project.src.data.AnimalType;
import project.src.data.ColorType;
import java.util.Arrays;


public class Verifier {
    public boolean animalTypeVerifier(String type) {
        for (AnimalType t : AnimalType.values()) {
            if (t.toString().equals(type))
                return true;
        }
            return false;
    }

    public boolean nameVerifier(String name) {
        char[] nameArr = name.toLowerCase().toCharArray();
        for (char letter : nameArr) {
            if (!((letter >= 'a' && letter <= 'z') || (letter >= 'а' && letter <= 'я'))) {
                System.out.println("Incorrect name format! Name should contain only letters (English or Russian)!");
                return false;
            }
        }
        return true;
    }

    public boolean ageVerifier(String age) {
        try {
            int result = Integer.parseInt(age);
            if (result > 0 && result < 31)
                return true;
        } catch (NumberFormatException ageException) {
            System.out.println("Catch NumberFormatException");
        }
        System.out.println("Incorrect age format! It must be Integer from 1 to 30!");
        return false;
    }

    public boolean weightVerifier(String weight) {
        try {
            double result = Double.parseDouble(weight);
            if (result > 0 && result < 156)
                return true;
        } catch (NumberFormatException ageException) {
            System.out.println("Catch NumberFormatException");
        }
        System.out.println("Incorrect weight format! It must be Double from 0+ to 155 kg (world record for dogs)!");
        return false;
    }

    public boolean colorVerifier(String color) {
        for (ColorType t : ColorType.values()) {
            if (t.toString().equals(color.toUpperCase()))
                return true;
        }
        System.out.println("Incorrect color! Choose one of " + Arrays.toString(ColorType.values()));
        return false;
    }

    public static void commonPrintf(String characteristic, String type) {
            System.out.printf("Input %s for a new %s:\n",characteristic, type);
    }


}
