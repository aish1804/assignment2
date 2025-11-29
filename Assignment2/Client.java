package RefactoringDesignPatterns.Assignment2;

import RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer;
import RefactoringDesignPatterns.RestaurantProject.src.src.main.ErieFamousRestaurant;
import RefactoringDesignPatterns.RestaurantProject.src.src.main.Phone;

public class Client {
    public static void main(String[] args) {
        RefactoringDesignPatterns.RestaurantProject.src.src.main.Customer nancy = new Customer("Nancy", "nancy@nancy.com", new Phone(814, 9999));
        RefactoringDesignPatterns.RestaurantProject.src.src.main.ErieFamousRestaurant restaurant = new ErieFamousRestaurant("Chicken Soup");

        restaurant.seatIn(nancy);

        try {
            restaurant.prepareFood();
        } catch (InterruptedException e) {
            System.out.println("Program interrupted while thread sleeping.");
        }

        while (true) {
            if(restaurant.isFoodReady()) {
                nancy.eat();
                break;
            }
        }
    }
}
