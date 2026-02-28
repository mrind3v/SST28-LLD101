public class InvoiceData {
    public final double subtotal;
    public final double tax;
    public final double taxPct;
    public final double discount;
    public final double total;

    public InvoiceData(double subtotal, double tax, double taxPct, double discount, double total) {
        this.subtotal = subtotal;
        this.tax = tax;
        this.taxPct = taxPct;
        this.discount = discount;
        this.total = total;
    }
}
