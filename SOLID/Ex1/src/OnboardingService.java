import java.util.*;

public class OnboardingService {
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final OnboardingRepository repository;
    private final OnboardingPrinter printer;
    public OnboardingService(FakeDb db, InputParser inputParser, InputValidator inputValidator, OnboardingRepository repository, OnboardingPrinter printer) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        this.repository = repository;
        this.printer = printer;
    }


    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {

        printer.printRawInput(raw);

        Map<String, String> kv = inputParser.parseInput(raw);
        List<String> errors = inputValidator.validateInput(kv);

        printer.printValidationError(errors);

        String id = IdUtil.nextStudentId(repository.count());
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("name", "");
        String phone = kv.getOrDefault("phone","");
        String program = kv.getOrDefault("program","");
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);


        repository.save(rec);

        printer.printSuccessMessage(rec,repository);
    }
}
