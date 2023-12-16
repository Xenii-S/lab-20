package lab2;
public class Calculator {
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number> double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static void main(String[] args) {
        int intResult = (int) Calculator.sum(5, 3); // Приведение типа, так как метод возвращает double
        double doubleResult = Calculator.multiply(2.5, 4.0);

        System.out.println("Sum: " + intResult);
        System.out.println("Multiply: " + doubleResult);
    }
}
