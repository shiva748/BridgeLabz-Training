class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog makes sound.");
    }
}

public class Jungle {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();

        a.makeSound(); // Animal version
        d.makeSound(); // Dog version (overridden)
    }
}
