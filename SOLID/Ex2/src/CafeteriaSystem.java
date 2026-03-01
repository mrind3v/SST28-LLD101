import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private final Repository repository;
    private final PricingCalculator pricingCalculator;
    private final InvoiceFormatter invoiceFormatter;
    private final IInvoiceIdGenerator iInvoiceIdGenerator;
    public CafeteriaSystem(PricingCalculator pricingCalculator, InvoiceFormatter invoiceFormatter, Repository repository, IInvoiceIdGenerator iInvoiceIdGenerator) {
        this.pricingCalculator = pricingCalculator;
        this.invoiceFormatter = invoiceFormatter;
        this.repository = repository;
        this.iInvoiceIdGenerator = iInvoiceIdGenerator;
    }
    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {

        InvoiceData invoiceData = pricingCalculator.calculate(lines,menu,customerType);

        String invId =  iInvoiceIdGenerator.nextId();
        String printable = invoiceFormatter.format(invId, invoiceData);
        System.out.print(printable);

        repository.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + repository.countLines(invId) + ")");
    }
}
