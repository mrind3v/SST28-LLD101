import java.util.ArrayList;
import java.util.List;

public class AttendanceRule implements EligibilityRule{
    private final double minAttendance;
    public AttendanceRule(double minAttendance) {
        this.minAttendance = minAttendance;
    }
    @Override
    public EligibilityEngineResult evaluate(StudentProfile student) {
        if (student.attendancePct < minAttendance) {
            return new EligibilityEngineResult("NOT_ELIGIBLE", List.of("attendance below 75"));
        } else {
            return new EligibilityEngineResult("ELIGIBLE", new ArrayList<>());
        }
    }

}
