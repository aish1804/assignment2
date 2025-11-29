package refproject;

import restaurant.Customer;
import restaurant.ErieFamousRestaurant;
import restaurant.Phone;

/**
 * Client class demonstrating the Observer Pattern
 *
 * KEY IMPROVEMENT: No more busy waiting loop!
 * The customer is automatically notified when food is ready through
 * the Observer pattern, eliminating the need for continuous polling.
 *
 * This demonstrates the "Hollywood Principle": "Don't call us, we'll call you"
 */
public class Client {
    public static void main(String[] args) {
        // Create customer
        Customer nancy = new Customer("Nancy", "nancy@nancy.com", new Phone(814, 9999));

        // Create restaurant with specific food item
        ErieFamousRestaurant restaurant = new ErieFamousRestaurant("Chicken Soup");

        // Seat customer - this automatically registers them as an observer
        restaurant.seatIn(nancy);

        // Prepare food - observers will be notified automatically when ready
        // No need to check status or coordinate customer behavior!
        try {
            restaurant.prepareFood();
        } catch (InterruptedException e) {
            System.out.println("Program interrupted while thread sleeping.");
            Thread.currentThread().interrupt(); // Restore interrupt status
        }
    }
}