import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputValidator {
    List<String> validateInput(Map<String,String> mp) {
        List<String> errors = new ArrayList<>();

        String name = mp.getOrDefault("name", "");
        String email = mp.getOrDefault("email", "");
        String phone = mp.getOrDefault("phone", "");
        String program = mp.getOrDefault("program", "");

        if (name.isBlank()) errors.add("name is required");
        if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");

        return errors;
    }
}
