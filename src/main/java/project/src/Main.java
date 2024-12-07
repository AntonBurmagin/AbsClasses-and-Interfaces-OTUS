package project.src;
import project.src.animals.AbsAnimal;
import project.src.data.AnimalTypes;
import project.src.factory.Factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
//        AbsAnimal animal = factory.create(AnimalTypes.DOG);
//        animal.setName("Bob");
//        animal.setAge(1);
//        animal.setWeight(18.5);
//        animal.setColor("Pink");
//        System.out.println(animal.toString());
//        animal.say();



        String order;
        Order orderType = null;
//      System.out.println(orderType.EXIT.toString());
//        while (true) {
//            System.out.println("What's your command (add, list, exit):");
//            Scanner input = new Scanner(System.in);
//            order = input.nextLine().trim().toUpperCase();
//            System.out.println(order);
//            if (order.equals(orderType.EXIT.toString())) {
//                System.out.println("Got exit. Goodbye!");
//                break;
//            } else if (order.equals(orderType.ADD.toString())) {
//                System.out.println("Got add");
//            } else if (order.equals(orderType.LIST.toString())) {
//                System.out.println("Got list");
//            } else {
//                System.out.println("Got nothing");
//            }
//        }
    }
}