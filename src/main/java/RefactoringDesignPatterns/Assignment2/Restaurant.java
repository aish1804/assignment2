package RefactoringDesignPatterns.Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    protected final String food;
    protected boolean foodReady = false;
    private final List<Customer> customers = new ArrayList<>();

    public Restaurant(String food) {
        this.food = food;
    }

    public boolean isFoodReady() {
        return foodReady;
    }

    public List<Customer> getCustomers() {
        // Return a defensive mutable copy so callers can modify it without affecting internal list
        return new ArrayList<>(customers);
    }

    public void registerObserver(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
            System.out.println("Observer registered");
        }
    }

    public void removeObserver(Customer customer) {
        if (customers.remove(customer)) {
            System.out.println("Observer removed");
        }
    }

    public void seatIn(Customer customer) {
        registerObserver(customer);
    }

    public String getFood() {
        return food;
    }
}
