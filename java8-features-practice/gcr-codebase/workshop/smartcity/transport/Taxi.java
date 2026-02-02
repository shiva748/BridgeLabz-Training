package smartcity.transport;

public class Taxi implements Vehicle {
	public TransportType type;
	public boolean avilable;
	public int charge;

	@Override
	public boolean book() {
		if (!avilable) {
			System.out.print("Taxi is already booked.");
			return false;
		}
		avilable = false;
		return true;
	}

	@Override
	public boolean free() {
		if (avilable) {
			System.out.print("Taxi is aleady free.");
			return false;
		}
		avilable = true;
		return true;
	}

	public Taxi(TransportType type, int charge) {
		super();
		this.type = type;
		this.charge = charge;
		this.avilable = true;
	}

	@Override
	public TransportType getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int getFare(int distance) {
		return distance * charge;
	}

	@Override
	public boolean isAvilable() {
		return avilable;
	}

}
