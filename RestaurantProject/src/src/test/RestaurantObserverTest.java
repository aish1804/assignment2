package RefactoringDesignPatterns.Assignment2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test suite for the refactored restaurant system using Observer Pattern
 * Tests verify that the Observer pattern is correctly implemented and
 * that no functionality was lost during refactoring
 */
@DisplayName("Restaurant Observer Pattern Tests")
class RestaurantObserverTest {

        private ErieFamousRestaurant restaurant;
        private Customer customer1;
        private Customer customer2;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        restaurant = new ErieFamousRestaurant("Chicken Soup");
        customer1 = new Customer("Alice", "alice@test.com", new Phone(814, 1111));
        customer2 = new Customer("Bob", "bob@test.com", new Phone(814, 2222));

        // Capture console output for testing
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Customer should be registered as observer when seated")
    void testCustomerRegistrationAsObserver() {
        restaurant.seatIn(customer1);

        assertTrue(restaurant.getCustomers().contains(customer1),
                "Customer should be in the restaurant's customer list");
        assertTrue(outputStream.toString().contains("Observer registered"),
                "System should confirm observer registration");
    }

    @Test
    @DisplayName("Multiple customers can be seated in the restaurant")
    void testMultipleCustomersSeated() {
        restaurant.seatIn(customer1);
        restaurant.seatIn(customer2);

        assertEquals(2, restaurant.getCustomers().size(),
                "Restaurant should have 2 customers");
        assertTrue(restaurant.getCustomers().contains(customer1),
                "Alice should be in customer list");
        assertTrue(restaurant.getCustomers().contains(customer2),
                "Bob should be in customer list");
    }

    @Test
    @Timeout(6) // Ensures test doesn't hang due to infinite loops
    @DisplayName("Observer should be notified when food is prepared")
    void testFoodPreparationNotifiesObservers() throws InterruptedException {
        restaurant.seatIn(customer1);

        assertFalse(restaurant.isFoodReady(), "Food should not be ready initially");

        restaurant.prepareFood();

        assertTrue(restaurant.isFoodReady(), "Food should be ready after preparation");
        String output = outputStream.toString();
        assertTrue(output.contains("Processing Chicken Soup"),
                "Should show food processing message");
        assertTrue(output.contains("Chicken Soup is ready!"),
                "Should show food ready message");
        assertTrue(output.contains("Alice has been notified"),
                "Alice should be notified");
        assertTrue(output.contains("Alice is eating"),
                "Alice should be eating");
    }

    @Test
    @Timeout(6)
    @DisplayName("All observers should be notified when food is ready")
    void testMultipleObserversNotified() throws InterruptedException {
        restaurant.seatIn(customer1);
        restaurant.seatIn(customer2);

        restaurant.prepareFood();

        String output = outputStream.toString();
        assertTrue(output.contains("Alice has been notified"),
                "Alice should be notified");
        assertTrue(output.contains("Bob has been notified"),
                "Bob should be notified");
        assertTrue(output.contains("Alice is eating"),
                "Alice should be eating");
        assertTrue(output.contains("Bob is eating"),
                "Bob should be eating");
    }

    @Test
    @DisplayName("Observer can be removed from notification list")
    void testObserverRemoval() {
        restaurant.seatIn(customer1);
        restaurant.registerObserver(customer2);

        restaurant.removeObserver(customer2);

        String output = outputStream.toString();
        assertTrue(output.contains("Observer removed"),
                "System should confirm observer removal");
    }

    @Test
    @DisplayName("Food ready status should be correctly tracked")
    void testFoodReadyStatus() throws InterruptedException {
        assertFalse(restaurant.isFoodReady(), "Food should not be ready initially");

        restaurant.prepareFor();

        assertTrue(restaurant.isFoodReady(), "Food should be ready after preparation");
    }

    @Test
    @DisplayName("Restaurant should return correct food name")
    void testRestaurantFoodName() {
        assertEquals("Chicken Soup", restaurant.getFood(),
                "Restaurant should return correct food name");
    }

    @Test
    @DisplayName("Customer properties should be accessible")
    void testCustomerProperties() {
        assertEquals("Alice", customer1.getName(),
                "Customer name should be Alice");
        assertEquals("alice@test.com", customer1.getEmail(),
                "Customer email should match");
        assertEquals(814, customer1.getPhoneNumber().getAreaCode(),
                "Area code should be 814");
        assertEquals(1111, customer1.getPhoneNumber().getNumber(),
                "Phone number should be 1111");
    }

    @Test
    @DisplayName("Phone equality should work correctly")
    void testPhoneEquals() {
        Phone phone1 = new Phone(814, 1234);
        Phone phone2 = new Phone(814, 1234);
        Phone phone3 = new Phone(814, 5678);

        assertEquals(phone1, phone2, "Phones with same values should be equal");
        assertNotEquals(phone1, phone3, "Phones with different values should not be equal");
    }

    @Test
    @DisplayName("Phone toString should format correctly")
    void testPhoneToString() {
        Phone phone = new Phone(814, 1234);
        assertEquals("(814) 1234", phone.toString(),
                "Phone should format as (area code) number");
    }

    @Test
    @Timeout(6)
    @DisplayName("No busy waiting loop should exist (performance test)")
    void testNoBusyWaiting() throws InterruptedException {
        // Critical test: Verify that the refactored code doesn't use busy waiting
        restaurant.seatIn(customer1);

        long startTime = System.currentTimeMillis();
        restaurant.prepareFood();
        long endTime = System.currentTimeMillis();

        // Should take approximately 5 seconds (sleep time)
        // Not significantly more due to busy waiting
        long duration = endTime - startTime;
        assertTrue(duration >= 5000 && duration < 5500,
                "Duration should be close to 5000ms (no busy waiting), was: " + duration + "ms");
    }

    @Test
    @DisplayName("Observer callback should be properly invoked")
    void testCustomerNotificationCallback() throws InterruptedException {
        // Test that the observer callback is properly invoked
        restaurant.seatIn(customer1);

        restaurant.prepareFood();

        String output = outputStream.toString();
        // Verify the entire notification flow
        assertTrue(output.contains("Alice has been notified that Chicken Soup is ready!"),
                "Complete notification message should be displayed");
    }

    @Test
    @DisplayName("Preparing food without observers should not cause errors")
    void testNoNotificationWithoutObservers() throws InterruptedException {
        // Test that preparing food without observers doesn't cause errors
        assertDoesNotThrow(() -> restaurant.prepareFood(),
                "Should not throw exception when no observers");
        assertTrue(restaurant.isFoodReady(), "Food should still be ready");
    }

    @Test
    @DisplayName("Phone hashCode should be consistent with equals")
    void testPhoneHashCode() {
        Phone phone1 = new Phone(814, 1234);
        Phone phone2 = new Phone(814, 1234);

        assertEquals(phone1.hashCode(), phone2.hashCode(),
                "Equal phones should have same hash code");
    }

    @Test
    @DisplayName("Customer list should return defensive copy")
    void testCustomerListEncapsulation() {
        restaurant.seatIn(customer1);
        List<Customer> customers = restaurant.getCustomers();
        int originalSize = customers.size();

        // Try to modify the returned list
        customers.add(customer2);

        // Original list should not be affected
        assertEquals(originalSize, restaurant.getCustomers().size(),
                "Original customer list should not be modified");
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}