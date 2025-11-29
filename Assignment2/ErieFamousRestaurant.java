package RefactoringDesignPatterns.Assignment2;

import RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer;
import RefactoringDesignPatterns.RestaurantProject.src.src.main.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErieFamousRestaurant extends Restaurant {
    private final List<RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer> customers = new ArrayList<>();

    public ErieFamousRestaurant(String food) {
        super(food);
    }

    public void prepareFood() throws InterruptedException {
        System.out.println("Processing food...");
        Thread.sleep(5000);
        this.foodReady = true;
        System.out.println("Food is ready!");
    }

    public void seatIn(Customer customer) {
        customers.add(customer);
    }

    public Collection<Object> getCustomers() {
        return null;
    }
}
