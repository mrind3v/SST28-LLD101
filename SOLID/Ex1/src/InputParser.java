import java.util.LinkedHashMap;
import java.util.Map;

public class InputParser {
   Map<String,String> parseInput(String raw) {
       Map<String,String> parsed = new LinkedHashMap<>();
       String[] parts = raw.split(";");
       for (String p : parts) {
           String[] t = p.split("=", 2);
           if (t.length == 2) parsed.put(t[0].trim(), t[1].trim());
       }
       return parsed;
   }
}
