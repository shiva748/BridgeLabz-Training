class Vehicle {
	int maxSpeed;
	String fuelType;

	public void displayInfo() {
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Fuel Type: " + fuelType);
	}
}

class Car extends Vehicle {
	int seatCapacity;

	@Override
	public void displayInfo() {
		System.out.println("Car Details:");
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Fuel Type: " + fuelType);
		System.out.println("Seat Capacity: " + seatCapacity);
	}
}

class Truck extends Vehicle {
	double loadCapacity;

	@Override
	public void displayInfo() {
		System.out.println("Truck Details:");
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Fuel Type: " + fuelType);
		System.out.println("Load Capacity: " + loadCapacity + " tons");
	}
}

class Motorcycle extends Vehicle {
	boolean hasGear;

	@Override
	public void displayInfo() {
		System.out.println("Motorcycle Details:");
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Fuel Type: " + fuelType);
		System.out.println("Has Gear: " + hasGear);
	}
}

public class Vehicles {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];

		vehicles[0] = new Car();
		vehicles[0].maxSpeed = 180;
		vehicles[0].fuelType = "Petrol";

		vehicles[1] = new Truck();
		vehicles[1].maxSpeed = 120;
		vehicles[1].fuelType = "Diesel";

		vehicles[2] = new Motorcycle();
		vehicles[2].maxSpeed = 160;
		vehicles[2].fuelType = "Petrol";

		for (Vehicle v : vehicles) {
			v.displayInfo();
		}
	}
}
