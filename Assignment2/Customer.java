package RefactoringDesignPatterns.Assignment2;

import RefactoringDesignPatterns.RestaurantProject.src.src.main.Phone;

public class Customer {
    private final String name;
    private final String email;
    private final RefactoringDesignPatterns.RestaurantProject.src.src.main.Phone phoneNumber;

    public Customer(String name, String email, RefactoringDesignPatterns.RestaurantProject.src.src.main.Phone phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String bob, String mail, phone phone, String name, String email, Phone phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String alice, String mail, phone phone, String name, String email, Phone phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String alice, String mail, phone phone) {
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
        System.out.println("Eating... ...!");
    }
}
