package MyZoo;

public class Dog extends Animal implements IGroundAnimal {
    public static int numOfDog = 0;
    private String name;
    public final int NORMALPRICE = 500;

    public Dog(String species, int age, String food, String name) {
        super(species, age, food);
        this.name = name;
        numOfDog++;
        System.out.println("DOG#" + numOfDog + " HAS BEEN CREATED");
    }

    @Override
    public void move() {
        System.out.println("Dog " + getName() + "run");
    }

    @Override
    public void sleep() {
        System.out.println("Dog " + getName() + "sleep");
    }

    @Override
    public void eat() {
        System.out.println("Dog " + getName() + " eat " + getFood());
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Species: " + getSpecies() + "\n" +
                        "Name: " + getName() + "\n" +
                        "Age: " + getAge() + "\n" +
                        "Food: " + getFood() + "\n"
        );
    }

    public void priceCalculate() {
        if (getSpecies() == "Shiba") {
            if (getAge() > 0 && getAge() < 10) {
                System.out.println("The price of dog is: " + getAge() * 1000 + "$\n");
            } else if (getAge() >= 10 && getAge() <= 20) {
                System.out.println("The price of dog is: " + getAge() * 700 + "$\n");
            } else {
                System.out.println("The price is ###\n");
            }
        } else {
            System.out.println("The price of dog is: " + getAge() * NORMALPRICE + "\n");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
