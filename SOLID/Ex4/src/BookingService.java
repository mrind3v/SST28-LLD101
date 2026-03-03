public class BookingService {
    private final HostelFeeCalculator hostelFeeCalculator;
    private final Repository repository;
    private final IBookingIdGenerator idGenerator;
    public BookingService(HostelFeeCalculator hostelFeeCalculator, Repository repository, IBookingIdGenerator idGenerator) {
        this.hostelFeeCalculator = hostelFeeCalculator;
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public void executeBooking(BookingRequest req) {
        FeeSummary summary = hostelFeeCalculator.calculate(req);
        ReceiptPrinter.print(req, summary.monthly, summary.deposit);
        String bookingId = idGenerator.nextId();
        repository.save(bookingId,req,summary.monthly,summary.deposit);
    }
}
