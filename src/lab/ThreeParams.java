package lab;
import java.io.Serializable;

public class ThreeParams<T extends Comparable<T>, V extends Animal, K extends Serializable> {
    private T valueT;
    private V valueV;
    private K valueK;

    public ThreeParams(T valueT, V valueV, K valueK) {
        this.valueT = valueT;
        this.valueV = valueV;
        this.valueK = valueK;
    }

    public T getValueT() {
        return valueT;
    }

    public V getValueV() {
        return valueV;
    }

    public K getValueK() {
        return valueK;
    }

    public void printClassNames() {
        System.out.println("Class of T: " + valueT.getClass().getName());
        System.out.println("Class of V: " + valueV.getClass().getName());
        System.out.println("Class of K: " + valueK.getClass().getName());
    }


}
