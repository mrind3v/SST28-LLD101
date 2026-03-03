import java.util.*;

public class EligibilityEngine {
    private final Repository repository;
    private final List<EligibilityRule> rules;
    private final IReportPrinter reportPrinter;


    public EligibilityEngine(Repository repository, List<EligibilityRule> rules,  IReportPrinter reportPrinter) {
        this.repository = repository;
        this.rules = rules;
        this.reportPrinter = reportPrinter;
    }

    public void runAndPrint(StudentProfile s) {
        EligibilityEngineResult r = evaluate(s);
        reportPrinter.print(s,r);
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

