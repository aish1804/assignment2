package RefactoringDesignPatterns.Assignment2;

import RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer;

import java.util.List;

public class restaurant {
    protected final String food;
    protected boolean foodReady = false;

    public restaurant(String food) {
        this.food = food;
    }

    public boolean isFoodReady() {
        return foodReady;
    }

    public List<RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer> getCustomers() {
        return List.of();
    }

    public void registerObserver(Customer customer2) {

    }
}
