import java.util.List;

public class OnboardingPrinter {
    // print raw input
    void printRawInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    // print validation errors
    void printValidationError(List<String> errors) {
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
        }
    }

    // print save success errors
    void printSuccessMessage(StudentRecord sr, OnboardingRepository repository) {

        System.out.println("OK: created student " + sr.id);
        System.out.println("Saved. Total students: " + repository.count());
        System.out.println("CONFIRMATION:");
        System.out.println(sr);
    }
}
