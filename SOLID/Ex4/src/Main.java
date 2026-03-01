import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        BookingIdGenerator bookingIdGenerator = new BookingIdGenerator();
        FakeBookingRepo fakeBookingRepo = new FakeBookingRepo();
        HostelFeeCalculator calc = new HostelFeeCalculator(fakeBookingRepo,bookingIdGenerator);
        calc.process(req);
    }
}
