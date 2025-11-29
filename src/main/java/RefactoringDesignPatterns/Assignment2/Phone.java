package RefactoringDesignPatterns.Assignment2;

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

    @Override
    public String toString() {
        return String.format("(%d) %d", areaCode, number);
    }
}
