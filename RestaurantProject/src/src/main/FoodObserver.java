package RefactoringDesignPatterns.RestaurantProject.src.src.main;

/**
 * Observer interface for the Observer Design Pattern
 * Observers are notified when food is ready
 */
public interface FoodObserver {
    /**
     * Called when the observed restaurant's food is ready
     * @param restaurant The restaurant that prepared the food
     * @param foodName The name of the food that was prepared
     */
    void onFoodReady(Restaurant restaurant, String foodName);
}
