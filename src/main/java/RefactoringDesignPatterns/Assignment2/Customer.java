package RefactoringDesignPatterns.Assignment2;

public class Customer implements FoodObserver {
    private final String name;
    private final String email;
    private final Phone phoneNumber;

    public Customer(String name, String email, Phone phoneNumber) {
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

    public Phone getPhoneNumber() {
        return phoneNumber;
    }

    public void eat() {
        System.out.println(getName() + " is eating... ...!");
    }

    @Override
    public void onFoodReady(Restaurant restaurant, String foodName) {
        System.out.println(getName() + " has been notified that " + foodName + " is ready!");
        eat();
    }
}
