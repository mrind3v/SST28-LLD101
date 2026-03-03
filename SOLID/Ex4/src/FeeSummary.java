public class FeeSummary {
    public final Money monthly;
    public final Money deposit;

    public FeeSummary(Money monthly, Money deposit) {
        this.monthly = monthly;
        this.deposit = deposit;
    }
}