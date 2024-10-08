package Utils;

import com.google.gson.*;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonUtills {
    @Test
    public static void getValueFromJson() {
        String key = "TMT";
        String filePath = "src/test/resources/DataConfig/credentials.json";
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
            JsonElement jsonElement = JsonParser.parseString(jsonString);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            System.out.println(jsonObject.get(key).getAsString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not found");

        }
    }
}
