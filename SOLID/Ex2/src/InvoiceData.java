import java.util.List;
import java.util.Map;

public class InvoiceData {
    public final double subtotal;
    public final double tax;
    public final double taxPct;
    public final double discount;
    public final double total;
    public final List<String> lines;
    public InvoiceData(double subtotal, double tax, double taxPct, double discount, double total, List<String> lines ) {
        this.subtotal = subtotal;
        this.tax = tax;
        this.taxPct = taxPct;
        this.discount = discount;
        this.total = total;
        this.lines = lines;
    }
}
