import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;
    private final Pricing pricing;

    public CafeteriaSystem(Pricing pricing) {
        this.pricing = pricing;
    }
    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        pricing.calculate(lines,menu,customerType);

        out.append(String.format("Subtotal: %.2f\n", pricing.getSubtotal()));
        out.append(String.format("Tax(%.0f%%): %.2f\n", pricing.getTaxPct(), pricing.getTax()));
        out.append(String.format("Discount: -%.2f\n", pricing.getDiscount()));
        out.append(String.format("TOTAL: %.2f\n", pricing.getTotal()));

        String printable = InvoiceFormatter.identityFormat(out.toString());
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
