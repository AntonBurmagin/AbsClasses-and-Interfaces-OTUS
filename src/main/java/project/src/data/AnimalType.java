package project.src.data;

public enum AnimalType {
    CAT,
    DOG,
    DUCK;

    public static boolean isAnimalType(String type) {
        for (AnimalType t : AnimalType.values()) {
            if (t.toString().equals(type))
                return true;
        }
        return false;
    }
}
