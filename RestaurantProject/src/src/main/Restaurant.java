package RefactoringDesignPatterns.RestaurantProject.src.src.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Restaurant class - Subject in Observer Pattern
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
     * @param observer The observer to register
     */
    public void registerObserver(FoodObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer registered for " + food);
        }
    }

    public void removeObserver(FoodObserver observer) {
        observers.remove(observer);
        System.out.println("Observer removed");
    }

    protected void notifyObservers() {
        for (FoodObserver observer : observers) {
            observer.onFoodReady(this, food);
        }
    }


    public abstract void prepareFood() throws InterruptedException;

    public void prepareFor() {
        
    }
}