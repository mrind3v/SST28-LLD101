import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        FakeEligibilityStore store = new FakeEligibilityStore();
        RuleInput input = new RuleInput();
        List<EligibilityRule> rules = List.of(
                new DisciplinaryRule(),
                new CgrRule(input.minCgr),
                new AttendanceRule(input.minAttendance),
                new CreditsRule(input.minCredits)
        );
        EligibilityEngine engine = new EligibilityEngine(store, rules);
        engine.runAndPrint(s);
    }
}
