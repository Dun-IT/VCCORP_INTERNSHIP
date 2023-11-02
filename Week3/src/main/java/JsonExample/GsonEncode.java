package JsonExample;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GsonEncode {
    //    public static void main(String[] args) {
//        //Tạo đối tượng Gson
//        Gson gson = new Gson();
//
//        //Chuyển đổi từ mảng sang JSON
//        Person arr[] = new Person[5];
//        arr[0] = new Person("John", 25, "American");
//        arr[1] = new Person("Chris", 30, "France");
//        arr[2] = new Person("Madeline", 19, "Colombia");
//        arr[3] = new Person("Anna", 21, "Russia");
//        arr[4] = new Person("Hoàng", 27, "Việt Nam");
//        String rs = gson.toJson(arr);
//        try (FileWriter fileWriter = new FileWriter("src/main/java/JsonExample/GsonFile.json")) {
//            fileWriter.write(rs);
//            fileWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(rs);
//    }
    public static void main(String args[]) {
        String json = "{ 'name':'Hoàng', 'age':29, 'address':'NewYork' }";
        Gson gson = new Gson();
        Person user = gson.fromJson(json, Person.class);
        System.out.println(user);
    }
}
