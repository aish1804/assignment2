package RefactoringDesignPatterns.RestaurantProject.src.src.main;

import java.util.ArrayList;
import java.util.List;

/**
  implementation of Restaurant 
 */
public class ErieFamousRestaurant extends Restaurant {
    private final List<RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer> customers = new ArrayList<>();

    public ErieFamousRestaurant(String food) {
        super(food);
    }

    /**
     * @throws InterruptedException if the thread is interrupted during preparation
     */
    @Override
    public void prepareFood() throws InterruptedException {
        System.out.println("Processing " + food + "...");
        Thread.sleep(5000); // Simulate food preparation time
        this.foodReady = true;
        System.out.println(food + " is ready!");

        // Notify all observers (customers) that food is ready
        
        notifyObservers();
    }

    public void seatIn(RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer customer) {
        customers.add(customer);
        // Register customer as observer so they get notified when food is ready
        registerObserver(customer);
        System.out.println(customer.getName() + " has been seated.");
    }

    /**
     * @return List of customers
     */
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
}