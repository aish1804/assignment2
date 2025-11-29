package RefactoringDesignPatterns.RestaurantProject.src.src.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of Restaurant (Concrete Subject in Observer Pattern)
 * Automatically notifies all observers (customers) when food preparation is complete
 * This eliminates the need for busy waiting or polling
 */
public class ErieFamousRestaurant extends Restaurant {
    private final List<RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer> customers = new ArrayList<>();

    public ErieFamousRestaurant(String food) {
        super(food);
    }

    /**
     * Prepare food and notify observers when complete
     * This method triggers the notification to all registered observers
     * @throws InterruptedException if the thread is interrupted during preparation
     */
    @Override
    public void prepareFood() throws InterruptedException {
        System.out.println("Processing " + food + "...");
        Thread.sleep(5000); // Simulate food preparation time
        this.foodReady = true;
        System.out.println(food + " is ready!");

        // Notify all observers (customers) that food is ready
        // This is the key line that triggers the Observer pattern
        notifyObservers();
    }

    /**
     * Seat a customer and register them as an observer
     * This automatically sets up the observer relationship
     * @param customer The customer to seat
     */
    public void seatIn(RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer customer) {
        customers.add(customer);
        // Register customer as observer so they get notified when food is ready
        registerObserver(customer);
        System.out.println(customer.getName() + " has been seated.");
    }

    /**
     * Get the list of seated customers
     * Returns a copy to maintain encapsulation
     * @return List of customers
     */
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
}