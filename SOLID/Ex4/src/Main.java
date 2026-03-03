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
        FakeBookingRepo fakeBookingRepo = new FakeBookingRepo();
        BookingIdGenerator bookingIdGenerator = new BookingIdGenerator();
        BookingService service = new BookingService(calc,fakeBookingRepo,bookingIdGenerator);
        service.executeBooking(req);
    }

}
