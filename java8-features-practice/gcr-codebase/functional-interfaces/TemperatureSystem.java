import java.util.function.Predicate;

public class TemperatureSystem {

	public static void main(String[] args) {

		double threshold = 40.0;

		Predicate<Double> alertCheck = temp -> temp > threshold;

		checkTemperature(35.5, alertCheck);
		checkTemperature(42.0, alertCheck);
		checkTemperature(39.0, alertCheck);
		checkTemperature(45.8, alertCheck);
	}

	public static void checkTemperature(double temperature, Predicate<Double> alertCheck) {

		if (alertCheck.test(temperature)) {
			System.out.println("Temperature " + temperature + " crossed threshold.");
			System.out.println("ALERT triggered.");
			return;
		}

		System.out.println("Temperature " + temperature + " is normal.");
	}
}
