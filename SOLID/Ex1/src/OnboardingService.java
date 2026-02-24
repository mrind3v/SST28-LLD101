import java.util.*;

public class OnboardingService {
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final Repository repository;
    public OnboardingService(FakeDb db, InputParser inputParser, InputValidator inputValidator, Repository repository) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        this.repository = repository;
    }


    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String, String> kv = inputParser.parseInput(raw);
        List<String> errors = inputValidator.validateInput(kv);

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }

        String id = IdUtil.nextStudentId(repository.count());
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("name", "");
        String phone = kv.getOrDefault("phone","");
        String program = kv.getOrDefault("program","");
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);


        repository.save(rec);

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + repository.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
