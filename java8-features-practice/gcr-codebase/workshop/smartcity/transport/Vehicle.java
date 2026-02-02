package smartcity.transport;

public interface Vehicle {
	public boolean isAvilable();

	public boolean book();

	public boolean free();

	public int getFare(int distance);

	public TransportType getType();
}
