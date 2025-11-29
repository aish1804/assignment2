package RefactoringDesignPatterns.Assignment2;

public class ErieFamousRestaurant extends Restaurant {
    public ErieFamousRestaurant(String food) {
        super(food);
    }

    public void prepareFood() throws InterruptedException {
        System.out.println("Processing " + getFood());
        Thread.sleep(5000);
        this.foodReady = true;
        System.out.println(getFood() + " is ready!");
        // Notify observers
        for (Customer c : getCustomers()) {
            try {
                c.onFoodReady(this, getFood());
            } catch (Exception e) {
                System.err.println("Observer notification failed: " + e.getMessage());
            }
        }
    }

    /**
     * A faster preparation method used by some tests to avoid sleeping
     */
    public void prepareFor() {
        this.foodReady = true;
    }
}
