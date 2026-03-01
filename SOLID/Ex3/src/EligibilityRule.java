public interface EligibilityRule {
    EligibilityEngineResult evaluate(StudentProfile student);
}
