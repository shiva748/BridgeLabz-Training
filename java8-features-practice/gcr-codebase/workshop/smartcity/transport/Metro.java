package smartcity.transport;

public class Metro implements Vehicle {
	private TransportType type;
	private int totalSeats;
	private int bookedSeats;
	private boolean avilable;
	private int charge;

	private boolean bookSeat() {
		bookedSeats++;
		if (bookedSeats == totalSeats) {
			avilable = false;
		}
		return true;
	}

	private boolean freeSeat() {
		if (bookedSeats == 0) {
			System.out.print("Metro is already empty");
			return false;
		}
		avilable = true;
		bookedSeats--;
		return true;
	}

	public Metro(TransportType type, int totalSeats, int charge) {
		super();
		this.type = type;
		this.totalSeats = totalSeats;
		this.bookedSeats = 0;
		this.charge = charge;
		this.avilable = true;
	}

	@Override
	public boolean book() {
		if (!avilable) {
			System.out.print("Metro is already full.");
			return false;
		}
		return bookSeat();
	}

	@Override
	public boolean free() {
		return freeSeat();
	}

	@Override
	public TransportType getType() {
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
