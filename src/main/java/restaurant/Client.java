package restaurant;

public class Client {
    public static void main(String[] args) {
        Customer nancy = new Customer("Nancy", "nancy@nancy.com", new Phone(814, 9999));
        ErieFamousRestaurant restaurant = new ErieFamousRestaurant("Chicken Soup");

        restaurant.seatIn(nancy);

        try {
            restaurant.prepareFood();
        } catch (InterruptedException e) {
            System.out.println("Program interrupted while thread sleeping.");
            Thread.currentThread().interrupt();
        }
    }
}
