public class InvoiceIdGenerator implements IInvoiceIdGenerator{

    private int invoiceSeq = 1000;
    public String nextId() {
        return "INV-" + (++invoiceSeq);
    }
}
