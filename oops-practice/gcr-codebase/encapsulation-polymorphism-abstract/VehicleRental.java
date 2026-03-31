import java.util.ArrayList;
import java.util.List;

interface Insurable {
	double calculateInsurance();

	String getInsuranceDetails();
}

abstract class Vehicle {
	private String vehicleNumber;
	private double rentalRate;

	Vehicle(String vehicleNumber, double rentalRate) {
		this.vehicleNumber = vehicleNumber;
		this.rentalRate = rentalRate;
	}

	double getRentalRate() {
		return rentalRate;
	}

	abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
	Car(String number, double rate) {
		super(number, rate);
	}

	double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	public double calculateInsurance() {
		return 500;
	}

	public String getInsuranceDetails() {
		return "Car Insurance";
	}
}

class Bike extends Vehicle {
	Bike(String number, double rate) {
		super(number, rate);
	}

	double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}
}

class Truck extends Vehicle implements Insurable {
	Truck(String number, double rate) {
		super(number, rate);
	}

	double calculateRentalCost(int days) {
		return getRentalRate() * days * 1.5;
	}

	public double calculateInsurance() {
		return 1000;
	}

	public String getInsuranceDetails() {
		return "Truck Insurance";
	}
}

public class VehicleRental {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();

		vehicles.add(new Car("CAR101", 1000));
		vehicles.add(new Bike("BIKE202", 300));
		vehicles.add(new Truck("TRUCK303", 2000));

		for (Vehicle v : vehicles) {
			double rent = v.calculateRentalCost(3);
			System.out.println("Rent: " + rent);

			if (v instanceof Insurable) {
				System.out.println("Insurance: " + ((Insurable) v).calculateInsurance());
			}
		}
	}
}
