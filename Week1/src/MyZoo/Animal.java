package MyZoo;

public abstract class Animal {
    private String species;
    private int age;
    private String food;

    public Animal(String species, int age, String food) {
        this.species = species;
        this.age = age;
        this.food = food;
    }

    public abstract void sleep();

    public abstract void eat();


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
