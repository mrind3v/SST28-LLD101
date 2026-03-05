public class HostelFeeCalculator {

    // OCP violation: switch + add-on branching + printing + persistence.
    public FeeDTO calculate(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        return new FeeDTO(monthly,deposit);
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
