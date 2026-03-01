public interface Repository {

    public void save(String id, BookingRequest req, Money monthly, Money deposit);
}
