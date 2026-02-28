import java.util.List;
import java.util.Map;

public class Pricing {
    double subtotal;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double tax;
    private double discount;
    private double taxPct;
    private double total;

    public double getTaxPct() {
        return taxPct;
    }

    public void setTaxPct(double taxPct) {
        this.taxPct = taxPct;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void calculate(List<OrderLine> lines, Map<String, MenuItem> menu, String customerType) {
        this.subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }

        this.taxPct = TaxRules.taxPercent(customerType);
        this.tax = subtotal * (taxPct / 100.0);

        this.discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());

        this.total = subtotal + tax - discount;

    }
}
