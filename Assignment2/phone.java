package RefactoringDesignPatterns.Assignment2;

public class phone {
    private final int areaCode;
    private final int number;

    public phone(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }
}
