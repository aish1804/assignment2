package RefactoringDesignPatterns.RestaurantProject.src.src.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Restaurant class - Subject in Observer Pattern
 * Maintains list of observers and notifies them when food is ready
 * This is the core of the Observer pattern implementation
 */
public abstract class Restaurant {
    protected final String food;
    protected boolean foodReady = false;
    private final List<FoodObserver> observers = new ArrayList<>();

    public Restaurant(String food) {
        this.food = food;
    }

    public boolean isFoodReady() {
        return foodReady;
    }

    public String getFood() {
        return food;
    }

    /**
     * Register an observer to be notified when food is ready
     * This implements the "attach" operation of the Observer pattern
     * @param observer The observer to register
     */
    public void registerObserver(FoodObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer registered for " + food);
        }
    }

    /**
     * Remove an observer from the notification list
     * This implements the "detach" operation of the Observer pattern
     * @param observer The observer to remove
     */
    public void removeObserver(FoodObserver observer) {
        observers.remove(observer);
        System.out.println("Observer removed");
    }

    /**
     * Notify all registered observers that food is ready
     * This implements the "notify" operation of the Observer pattern
     * Called by subclasses when the state changes (food becomes ready)
     */
    protected void notifyObservers() {
        for (FoodObserver observer : observers) {
            observer.onFoodReady(this, food);
        }
    }

    /**
     * Abstract method for preparing food - to be implemented by subclasses
     * Subclasses must call notifyObservers() when food is ready
     */
    public abstract void prepareFood() throws InterruptedException;

    public void prepareFor() {
        
    }
}