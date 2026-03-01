import java.util.*;

public class HostelFeeCalculator {
    private final Repository repo;
    private final IBookingIdGenerator iBookingIdGenerator;

    public HostelFeeCalculator(Repository repo, IBookingIdGenerator iBookingIdGenerator) {
        this.repo = repo;
        this.iBookingIdGenerator = iBookingIdGenerator;
    }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = iBookingIdGenerator.nextId();
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = req.roomType.getBasePrice();

        double add = 0.0;
        for (AddOnType addOnType : req.addOns) {
            add+=addOnType.getPrice();
        }

        return new Money(base + add);
    }
}
