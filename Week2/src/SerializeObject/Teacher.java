package SerializeObject;

import java.io.Serializable;

public class Teacher implements Serializable {
    private int maSo;
    private String hoTen;

    public Teacher(int maSo, String hoTen) {
        this.maSo = maSo;
        this.hoTen = hoTen;
    }
}
