package Utils;

import com.google.gson.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.json.Json;

public class JsonUtills {
    @Test
    public static void getValueFromJson(String path,String key) {

        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
            JsonElement jsonElement = JsonParser.parseString(jsonString);
            String value = findValue(jsonElement, key);
            if (value != null) {
                System.out.println(value);
            } else {
                System.out.println("Key not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading JSON");
        }
    }

    private static String findValue(JsonElement element, String key) {
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (String k : jsonObject.keySet()) {
                if (k.equals(key)) {
                    return jsonObject.get(k).getAsString();
                }
                String foundValue = findValue(jsonObject.get(k), key);
                if (foundValue != null) {
                    return foundValue;
                }
            }
        } else if (element.isJsonArray()) {
            for (JsonElement arrayElement : element.getAsJsonArray()) {
                String foundValue = findValue(arrayElement, key);
                if (foundValue != null) {
                    return foundValue;
                }
            }
        }
        return null;
    }

}
