import java.util.*;

public class FileStore implements Repository {
    private final Map<String, String> files = new HashMap<>();

    public int save(String name, String content) {
        files.put(name, content);
        return countLines(name);
    }

    public int countLines(String name) {
        String c = files.getOrDefault(name, "");
        if (c.isEmpty()) return 0;
        return c.split("\n").length;
    }
}
