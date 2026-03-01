import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final Repository repository;
    private final PricingCalculator pricingCalculator;
    private final InvoiceFormatter invoiceFormatter;
    private final IInvoiceIdGenerator iInvoiceIdGenerator;
    private final OutputDisplay outputDisplay;
    public CafeteriaSystem(PricingCalculator pricingCalculator, InvoiceFormatter invoiceFormatter, Repository repository, IInvoiceIdGenerator iInvoiceIdGenerator, OutputDisplay outputDisplay) {
        this.pricingCalculator = pricingCalculator;
        this.invoiceFormatter = invoiceFormatter;
        this.repository = repository;
        this.iInvoiceIdGenerator = iInvoiceIdGenerator;
        this.outputDisplay = outputDisplay;
    }
    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {

        InvoiceData invoiceData = pricingCalculator.calculate(lines,menu,customerType);

        String invId =  iInvoiceIdGenerator.nextId();
        String printable = invoiceFormatter.format(invId, invoiceData);
        outputDisplay.showInvoice(printable);


        int orderLines = repository.save(invId, printable);
        outputDisplay.showSaveConfirmation(invId, orderLines);

    }
}
