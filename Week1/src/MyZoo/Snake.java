package MyZoo;

public class Snake extends Animal implements IGroundAnimal {

    public static int numOfSnake = 0;
    private boolean isPoisonous = false;

    public Snake(String species, int age, String food, boolean isPoisonous) {
        super(species, age, food);
        this.isPoisonous = isPoisonous;
        numOfSnake++;
        System.out.println("SNAKE#" + numOfSnake + " HAS BEEN CREATED");
    }

    @Override
    public void sleep() {
        System.out.println("Species " + getSpecies() + "is sleep at night");
    }

    @Override
    public void eat() {
        System.out.println(getSpecies() + " snake eat " + getFood());
    }

    @Override
    public void move() {
        if (getAge() < 0) {
            System.out.println(getSpecies() + " Snake wasn't born \n");
        } else if (getAge() == 1) {
            System.out.println(getSpecies() + " Snake stay with parent \n");
        } else {
            System.out.println(getSpecies() + " Snake move alone \n");
        }
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Species: " + getSpecies() + "\n" + "Age: " + getAge() + "\n" +
                        "Food: " + getFood() + "\n" + "Is poisonous: " + isPoisonous() + "\n"
        );
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }
}
