import java.util.List;
import java.util.Map;

public class PricingCalculator {

    public InvoiceData calculate(List<OrderLine> lines, Map<String, MenuItem> menu, String customerType) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        return new InvoiceData(subtotal,tax,taxPct,discount,total);

    }
}
