import java.util.*;

public class ReceiptPrinter {
    public static void print(BookingRequest req, Money monthly, Money deposit) {
        List<String> addOnNames = new ArrayList<>();
        for (AddOnType addOnType : req.addOns) {
            addOnNames.add(addOnType.getName());
        }
        String addOnNamesString = addOnNames.toString();
        System.out.println("Room: " + req.roomType.getName() + " | AddOns: " + addOnNamesString);
        System.out.println("Monthly: " + monthly);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }
}
