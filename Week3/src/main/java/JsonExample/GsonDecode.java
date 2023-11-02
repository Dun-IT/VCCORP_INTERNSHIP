package JsonExample;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class GsonDecode {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person[] people = null;

        try (FileReader fileReader = new FileReader("src/main/java/JsonExample/GsonFile.json")) {
            people = gson.fromJson(fileReader, Person[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Person p : people) {
            System.out.println(p);
        }
    }
}
