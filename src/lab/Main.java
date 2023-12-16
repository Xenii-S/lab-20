package lab;

public class Main {
    public static void main(String[] args) {
        ThreeParams<Integer, Cat, String> example = new ThreeParams<>(42, new Cat("Basya"), "stroca");

        System.out.println("Value of T: " + example.getValueT());
        System.out.println("Value of V: " + example.getValueV());
        System.out.println("Value of K: " + example.getValueK());

        example.printClassNames();
    }
}
