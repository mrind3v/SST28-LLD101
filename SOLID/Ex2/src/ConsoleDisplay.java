public class ConsoleDisplay implements OutputDisplay{
    public void showInvoice(String message) {
        System.out.println(message);
    }
    public void showSaveConfirmation(String id, int count) {
        System.out.println( "Saved invoice: " + id + " (lines=" + count + ")" );
    }
}
