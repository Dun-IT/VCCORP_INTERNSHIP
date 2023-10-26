package SerializeObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TeacherDeserialization {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/SerializeObject/teacher.ser"))) {
            // Đọc đối tượng từ tệp tin
            Teacher deserializedTeacher = (Teacher) in.readObject();
            System.out.println("Deserialized teacher: " + deserializedTeacher);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
