import java.util.ArrayList;
import java.util.List;

public class CreditsRule implements EligibilityRule{
    private final double minCredits;
    public CreditsRule(double minCredits) {
        this.minCredits = minCredits;
    }
    @Override
    public EligibilityEngineResult evaluate(StudentProfile student) {
        if (student.earnedCredits < minCredits) {
            return new EligibilityEngineResult("NOT_ELIGIBLE", List.of("credits below 20"));
        } else {
            return new EligibilityEngineResult("ELIGIBLE", new ArrayList<>());
        }
    }
}
