public class RentalSystem {

	public static void main(String[] args) {

		RentalVehicle car = new Car("Honda City");
		RentalVehicle bike = new Bike("Royal Enfield");
		RentalVehicle bus = new Bus("Volvo");

		car.rent();
		car.rent();
		bike.rent();
		bus.returnVehicle();
		bus.rent();
		car.returnVehicle();
		bike.returnVehicle();
		bus.returnVehicle();
	}

}

interface RentalVehicle {

	public void rent();

	public void returnVehicle();
}

class Car implements RentalVehicle {

	private boolean rented;
	private String name;

	public Car(String name) {
		this.rented = false;
		this.name = name;
	}

	@Override
	public void rent() {
		if (rented) {
			System.out.println(name + " Car already rented.");
			return;
		}
		rented = true;
		System.out.println(name + " Car rented.");
	}

	@Override
	public void returnVehicle() {
		if (!rented) {
			System.out.println(name + " Car already returned.");
			return;
		}
		rented = false;
		System.out.println(name + " Car returned.");
	}
}

class Bike implements RentalVehicle {

	private boolean rented;
	private String name;

	public Bike(String name) {
		this.rented = false;
		this.name = name;
	}

	@Override
	public void rent() {
		if (rented) {
			System.out.println(name + " Bike already rented.");
			return;
		}
		rented = true;
		System.out.println(name + " Bike rented.");
	}

	@Override
	public void returnVehicle() {
		if (!rented) {
			System.out.println(name + " Bike already returned.");
			return;
		}
		rented = false;
		System.out.println(name + " Bike returned.");
	}
}

class Bus implements RentalVehicle {

	private boolean rented;
	private String name;

	public Bus(String name) {
		this.rented = false;
		this.name = name;
	}

	@Override
	public void rent() {
		if (rented) {
			System.out.println(name + " Bus already rented.");
			return;
		}
		rented = true;
		System.out.println(name + " Bus rented.");
	}

	@Override
	public void returnVehicle() {
		if (!rented) {
			System.out.println(name + " Bus already returned.");
			return;
		}
		rented = false;
		System.out.println(name + " Bus returned.");
	}
}
