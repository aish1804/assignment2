package restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    protected final String food;
    protected boolean foodReady = false;
    private final List<FoodObserver> observers = new ArrayList<>();

    public Restaurant(String food) {
        this.food = food;
    }

    public boolean isFoodReady() {
        return foodReady;
    }

    public List<FoodObserver> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    public void registerObserver(FoodObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    protected void notifyObservers() {
        for (FoodObserver o : observers) {
            try {
                o.onFoodReady(this, food);
            } catch (Exception e) {
                // keep notifying others even if one observer fails
                System.err.println("Observer notification failed: " + e.getMessage());
            }
        }
    }

    public void seatIn(FoodObserver customer) {
        registerObserver(customer);
    }
}
