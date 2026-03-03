import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        DoubleSharing doubleSharing = new DoubleSharing();
        LaundaryService laundaryService = new LaundaryService();
        MessService messService = new MessService();
        GymService gymService = new GymService();
        BookingRequest req = new BookingRequest(doubleSharing, List.of(laundaryService, messService));
        HostelFeeCalculator calc = new HostelFeeCalculator();
        FeeSummary summary = calc.calculate(req);
        ReceiptPrinter.print(req, summary.monthly, summary.deposit);
        BookingIdGenerator bookingIdGenerator = new BookingIdGenerator();
        FakeBookingRepo fakeBookingRepo = new FakeBookingRepo();
        fakeBookingRepo.save(bookingIdGenerator.nextId(),req,summary.monthly, summary.deposit);
    }

}
