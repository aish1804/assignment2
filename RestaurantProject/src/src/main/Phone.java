package RefactoringDesignPatterns.RestaurantProject.src.src.main;

/**
 * Phone class - Value object representing a phone number
 * Enhanced with equals, hashCode, and toString methods
 */
public class Phone {
    private final int areaCode;
    private final int number;

    public Phone(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "(" + areaCode + ") " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return areaCode == phone.areaCode && number == phone.number;
    }

    @Override
    public int hashCode() {
        return 31 * areaCode + number;
    }
}