public class FakeBookingRepo implements Repository{
    public void save(String id, BookingRequest req, Money monthly, Money deposit) {
        System.out.println("Saved booking: " + id);
    }
}
