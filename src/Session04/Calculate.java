package Session04;

public class Calculate {

    public static int add(int a, int b) {
        return a + b;
    }
    public static int minus(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Cannot Divide by zero");
        }
        return (double) a / b;
    }
}
