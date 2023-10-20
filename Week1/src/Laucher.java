import MyZoo.Dog;
import MyZoo.IGroundAnimal;
import MyZoo.Snake;

import java.util.ArrayList;
import java.util.List;

public class Laucher {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Shiba", 15, "Bone, meat", "Bob");
        Dog dog2 = new Dog("Alaska", 30, "Bone, meat, fish", "Alvin");
        Snake snake1 = new Snake("Black", 1, "Fly animal", true);
        Snake snake2 = new Snake("Green", 2, "Leaf", false);
        List<IGroundAnimal> myList = new ArrayList<>();
        myList.add(dog1);
        myList.add(dog2);
        myList.add(snake1);
        myList.add(snake2);

        System.out.println("\n######## MY ZOO ########\n");
        for (IGroundAnimal i : myList) {
            i.printInfo();
        }
    }
}
