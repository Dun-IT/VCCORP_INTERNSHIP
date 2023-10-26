package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class HotGirl {
    private String needAttention;
    List<Observer> boyList = new ArrayList<>();

    public String getNeedAttention() {
        return needAttention;
    }

    public void setNeedAttention(String needAttention) {
        this.needAttention = needAttention;
        update();
    }

    public void addFriend(Observer observer) {
        if (!boyList.contains(observer)) {
            boyList.add(observer);
        }
    }

    public void unFriend(Observer observer) {
        if (boyList.contains(observer)) {
            boyList.remove(observer);
        }
    }

    public void update() {
        if (getNeedAttention() == "Sad") {
            for (Observer boy : boyList) {
                boy.care();
            }
        }

        if (getNeedAttention() == "Happy") {
            for (Observer boy : boyList) {
                boy.sendGift();
            }
        }
    }
}
