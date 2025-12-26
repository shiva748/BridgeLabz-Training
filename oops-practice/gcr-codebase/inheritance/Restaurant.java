interface Worker {
	void performDuties();
}

class Person {
	String name;
	int id;

	public void displayRole() {
		System.out.println("Person");
	}
}

class Chef extends Person implements Worker {

	@Override
	public void performDuties() {
		System.out.println("Chef is preparing food");
	}

	@Override
	public void displayRole() {
		System.out.println("Chef");
	}
}

class Waiter extends Person implements Worker {

	@Override
	public void performDuties() {
		System.out.println("Waiter is serving customers");
	}

	@Override
	public void displayRole() {
		System.out.println("Waiter");
	}
}

public class Restaurant {
	public static void main(String[] args) {
		Person p1 = new Chef();
		Person p2 = new Waiter();

		p1.displayRole();
		((Worker) p1).performDuties();

		p2.displayRole();
		((Worker) p2).performDuties();
	}
}
