import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        DoubleSharing doubleSharing = new DoubleSharing();
        LaundaryService laundaryService = new LaundaryService();
        MessService messService = new MessService();
        GymService gymService = new GymService();
        BookingRequest req = new BookingRequest(doubleSharing, List.of(laundaryService, messService));
        BookingIdGenerator bookingIdGenerator = new BookingIdGenerator();
        FakeBookingRepo fakeBookingRepo = new FakeBookingRepo();
        HostelFeeCalculator calc = new HostelFeeCalculator(fakeBookingRepo,bookingIdGenerator);
        calc.process(req);
    }
}
