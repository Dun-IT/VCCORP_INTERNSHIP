package JsonExample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonEncode {
    public static void main(String[] args) {
        // JSONobject
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Doan");
        jsonObject1.put("age", new Integer(21));

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name", "Khoa");
        jsonObject2.put("age", new Integer(22));

        // Json Array
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        System.out.println(jsonArray);

        try (FileWriter fileWriter = new FileWriter("src/main/java/JsonExample/JsonFile.json")) {
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
