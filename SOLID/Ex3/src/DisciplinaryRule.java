import java.util.ArrayList;
import java.util.List;

public class DisciplinaryRule implements EligibilityRule{
   @Override
    public EligibilityEngineResult evaluate(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return new EligibilityEngineResult("NOT_ELIGIBLE", List.of("disciplinary flag present"));
        } else {
            return new EligibilityEngineResult("ELIGIBLE", new ArrayList<>());
        }
    }
}
