package restaurant;

public class ErieFamousRestaurant extends Restaurant {
    public ErieFamousRestaurant(String food) {
        super(food);
    }

    public void prepareFood() throws InterruptedException {
        System.out.println("Processing food...");
        Thread.sleep(2000);
        this.foodReady = true;
        System.out.println("Food is ready!");
        notifyObservers();
    }
}
