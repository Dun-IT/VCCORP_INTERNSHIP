package ObserverPattern;

public class laucher {
    public static void main(String[] args) {
        HotGirl hotGirl = new HotGirl();

        hotGirl.addFriend(new Boy("Doan"));
        hotGirl.addFriend(new Boy("Khoa"));
        hotGirl.addFriend(new Boy("Nguyen"));
        hotGirl.setNeedAttention("Sad");

        hotGirl.addFriend((new Boy("Noadd")));
        hotGirl.setNeedAttention("Happy");

    }
}
