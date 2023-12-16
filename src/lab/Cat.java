package lab;
import java.io.Serializable;
class Cat implements Animal, Serializable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return "Cat "  + name;
    }
}