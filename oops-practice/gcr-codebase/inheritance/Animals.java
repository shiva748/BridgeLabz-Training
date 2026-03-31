class Animal {
	String name;
	int age;

	public void makeSound() {
		System.out.println("Animal Make a sound");
	}
}

class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Dog Bark");
	}
}

class Cat extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Cat Meow");
	}
}

class Bird extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Bird Chirping");
	}
}

public class Animals {
	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal dog = new Dog();
		Animal bird = new Bird();
		cat.makeSound();
		bird.makeSound();
		dog.makeSound();
	}
}