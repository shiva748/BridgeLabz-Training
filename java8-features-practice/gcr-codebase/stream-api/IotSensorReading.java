import java.util.Arrays;
import java.util.List;

class SensorReading {
	private String sensorId;
	private double value;

	SensorReading(String sensorId, double value) {
		this.sensorId = sensorId;
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public String toString() {
		return sensorId + " -> " + value;
	}
}

public class IotSensorReading {
	public static void main(String[] args) {

		List<SensorReading> readings = Arrays.asList(new SensorReading("S1", 45.2), new SensorReading("S2", 78.9),
				new SensorReading("S3", 32.5), new SensorReading("S4", 90.1), new SensorReading("S5", 60.0));

		double threshold = 50.0;

		readings.stream().filter(r -> r.getValue() > threshold).forEach(System.out::println);
	}
}
