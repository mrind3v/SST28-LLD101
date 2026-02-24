import java.util.List;

public interface OnboardingRepository {
    void save(StudentRecord sr);
    int count();
    List<StudentRecord> all();
}
