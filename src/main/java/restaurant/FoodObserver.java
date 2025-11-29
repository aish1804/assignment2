package restaurant;

public interface FoodObserver {
    void onFoodReady(Restaurant restaurant, String foodName);
}
