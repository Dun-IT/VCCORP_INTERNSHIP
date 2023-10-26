package SerializeObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TeacherSerialization {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(10, "Nguyen Van A");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/SerializeObject/teacher.ser"))) {
            // Serialize đối tượng và ghi vào tệp tin
            out.writeObject(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
