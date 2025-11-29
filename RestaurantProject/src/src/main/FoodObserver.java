package RefactoringDesignPatterns.RestaurantProject.src.src.main;

public interface FoodObserver {
    /**
     * Called when the observed restaurant's food is ready
     */
    void onFoodReady(Restaurant restaurant, String foodName);
}
