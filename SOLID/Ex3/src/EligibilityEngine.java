import java.util.*;

public class EligibilityEngine {
    private final Repository repository;
    private final List<EligibilityRule> rules;


    public EligibilityEngine(Repository repository, List<EligibilityRule> rules) {
        this.repository = repository;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        repository.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {

        for (EligibilityRule rule : rules) {
            EligibilityEngineResult ruleResult = rule.evaluate(s);
            if ("NOT_ELIGIBLE".equals(ruleResult.status)) {
                return ruleResult;
            }
        }
        return new EligibilityEngineResult("ELIGIBLE", new ArrayList<>());
    }
}

