package JsonExample;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDecode {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader("src/main/java/JsonExample/JsonFile.json")) {
            Object object = jsonParser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) object;
            System.out.println(jsonArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
