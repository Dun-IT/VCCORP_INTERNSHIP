package ObserverPattern;

public class Boy implements Observer {
    private String name;

    public Boy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void care() {
        System.out.println(getName() + ": are you ok?");
    }

    @Override
    public void sendGift() {
        System.out.println("Sending gift from " + getName());
    }
}
