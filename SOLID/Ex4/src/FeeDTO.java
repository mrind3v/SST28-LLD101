public class FeeDTO {
    public final Money monthly;
    public final Money deposit;

    public FeeDTO(Money monthly, Money deposit) {
        this.monthly = monthly;
        this.deposit = deposit;
    }
}