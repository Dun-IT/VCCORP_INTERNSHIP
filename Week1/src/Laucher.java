import MyZoo.Dog;
import MyZoo.Snake;

public class Laucher {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Shiba", 15, "Bone, meat", "Bob");
        dog1.printInfo();
        dog1.priceCalculate();

        Dog dog2 = new Dog("Alaska", 30, "Bone, meat, fish", "Alvin");
        dog2.printInfo();

        Snake snake1 = new Snake("Black", 1, "Fly animal", true);
        snake1.printInfo();
        snake1.move();

        Snake snake2 = new Snake("Green", 2, "Leaf", false);
        snake2.printInfo();
        snake2.move();
    }
}
