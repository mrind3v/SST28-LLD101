import java.util.Random;

public class BookingIdGenerator implements IBookingIdGenerator{

    @Override
    public String nextId() {
        return "H-" + (7000 + new Random(1).nextInt(1000));
    }
}
