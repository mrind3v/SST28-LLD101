import java.util.ArrayList;
import java.util.List;

public class CgrRule implements EligibilityRule{

    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }
    @Override
    public EligibilityEngineResult evaluate(StudentProfile student) {
        if (student.cgr < minCgr) {
            return new EligibilityEngineResult("NOT_ELIGIBLE", List.of("CGR below 8.0"));
        } else {
            return new EligibilityEngineResult("ELIGIBLE", new ArrayList<>());
        }
    }
}
