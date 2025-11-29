package RefactoringDesignPatterns.RestaurantProject.src.src.main;

import RefactoringDesignPatterns.Assignment2.ErieFamousRestaurant;
import RefactoringDesignPatterns.Assignment2.phone;

/**
 Customer class implementing FoodObserver
 */
public class Customer implements FoodObserver {
    private final String name;
    private final String email;
    private final phone phoneNumber;

    public Customer(String name, String email, phone phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public phone getPhoneNumber() {
        return phoneNumber;
    }

    /**
     Customer eats the food
     */
    public void eat() {
        System.out.println(name + " is eating... ...!");
    }

   
    @Override
    public void onFoodReady(Restaurant restaurant, String foodName) {
        System.out.println(name + " has been notified that " + foodName + " is ready!");
        eat();
    }

    public void onFoodReady(ErieFamousRestaurant erieFamousRestaurant, boolean food) {
    }

    public void onFoodReady(RefactoringDesignPatterns.src.main.java.RefactoringDesignPatterns.Assignment2.ErieFamousRestaurant erieFamousRestaurant, boolean food) {
        
    }
}
