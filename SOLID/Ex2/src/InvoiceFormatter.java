public class InvoiceFormatter {


    public String format(String invId, int invoiceSeq, InvoiceData invoiceData) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");
        out.append(String.format("Subtotal: %.2f\n", invoiceData.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", invoiceData.taxPct, invoiceData.tax));
        out.append(String.format("Discount: -%.2f\n",invoiceData.discount));
        out.append(String.format("TOTAL: %.2f\n",invoiceData.total));
        return out.toString();
    }
}
