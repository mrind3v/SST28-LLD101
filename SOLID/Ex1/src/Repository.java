import java.util.List;

public interface Repository {
    void save(StudentRecord sr);
    int count();
    List<StudentRecord> all();
}
