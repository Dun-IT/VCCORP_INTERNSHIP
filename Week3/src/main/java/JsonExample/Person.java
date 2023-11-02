package JsonExample;

public class Person {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String toString() {
        return name + " - " + age + " - " + address;
    }
}
