public class FakeEligibilityStore implements Repository{
    public void save(String roll, String status) {
        System.out.println("Saved evaluation for roll=" + roll);
    }
}
