import java.util.Scanner;

abstract class GoodsTransport {
	protected String transportId;
	protected String transportDate;
	protected int transportRating;

	public GoodsTransport(String transportId, String transportDate, int transportRating) {
		this.transportId = transportId;
		this.transportDate = transportDate;
		this.transportRating = transportRating;
	}

	public String getTransportId() { return transportId; }
	public String getTransportDate() { return transportDate; }
	public int getTransportRating() { return transportRating; }

	public abstract String vehicleSelection();
	public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;

	public BrickTransport(String id, String date, int rating, float size, int qty, float price) {
		super(id, date, rating);
		this.brickSize = size;
		this.brickQuantity = qty;
		this.brickPrice = price;
	}

	public float getBrickSize() { return brickSize; }
	public int getBrickQuantity() { return brickQuantity; }
	public float getBrickPrice() { return brickPrice; }

	public String vehicleSelection() {
		if (brickQuantity < 300) return "Truck";
		if (brickQuantity <= 500) return "Lorry";
		return "MonsterLorry";
	}

	public float calculateTotalCharge() {
		float base = brickPrice * brickQuantity;
		float tax = base * 0.3f;
		float discount = 0f;

		if (transportRating == 5) discount = base * 0.20f;
		else if (transportRating == 3 || transportRating == 4) discount = base * 0.10f;

		float vehicleCost = Utility.vehicleCost(vehicleSelection());
		return (base + tax + vehicleCost) - discount;
	}
}

class TimberTransport extends GoodsTransport {
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;

	public TimberTransport(String id, String date, int rating, float length, float radius, String type, float price) {
		super(id, date, rating);
		this.timberLength = length;
		this.timberRadius = radius;
		this.timberType = type;
		this.timberPrice = price;
	}

	public String getTimberType() { return timberType; }
	public float getTimberPrice() { return timberPrice; }

	public String vehicleSelection() {
		float area = (float)(2 * 3.147 * timberRadius * timberLength);
		if (area < 250) return "Truck";
		if (area <= 400) return "Lorry";
		return "MonsterLorry";
	}

	public float calculateTotalCharge() {
		float volume = (float)(3.147 * timberRadius * timberRadius * timberLength);
		float rate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;
		float price = volume * timberPrice * rate;
		float tax = price * 0.3f;
		float discount = 0f;

		if (transportRating == 5) discount = price * 0.20f;
		else if (transportRating == 3 || transportRating == 4) discount = price * 0.10f;

		float vehicleCost = Utility.vehicleCost(vehicleSelection());
		return (price + tax + vehicleCost) - discount;
	}
}

class Utility {

	public static GoodsTransport parseDetails(String input) {
		String[] data = input.split(":");
		String id = data[0];
		String date = data[1];
		int rating = Integer.parseInt(data[2]);
		String type = data[3];

		if (type.equalsIgnoreCase("BrickTransport")) {
			float size = Float.parseFloat(data[4]);
			int qty = Integer.parseInt(data[5]);
			float price = Float.parseFloat(data[6]);
			return new BrickTransport(id, date, rating, size, qty, price);
		}

		if (type.equalsIgnoreCase("TimberTransport")) {
			float len = Float.parseFloat(data[4]);
			float rad = Float.parseFloat(data[5]);
			String tType = data[6];
			float price = Float.parseFloat(data[7]);
			return new TimberTransport(id, date, rating, len, rad, tType, price);
		}

		return null;
	}

	public static boolean validateTransportId(String transportId) {
		if (!transportId.matches("RTS\\d{3}[A-Z]")) {
			System.out.println("Transport id " + transportId + " is invalid");
			System.out.println("Please provide a valid record");
			return false;
		}
		return true;
	}

	public static String findObjectType(GoodsTransport obj) {
		if (obj instanceof TimberTransport) return "TimberTransport";
		if (obj instanceof BrickTransport) return "BrickTransport";
		return "";
	}

	public static float vehicleCost(String type) {
		if (type.equalsIgnoreCase("Truck")) return 1000f;
		if (type.equalsIgnoreCase("Lorry")) return 1700f;
		return 3000f;
	}
}

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Goods Transport details");
		String input = sc.nextLine();

		GoodsTransport gt = Utility.parseDetails(input);

		if (!Utility.validateTransportId(gt.getTransportId())) return;

		String objType = Utility.findObjectType(gt);
		float total = gt.calculateTotalCharge();

		System.out.println("Transporter id : " + gt.getTransportId());
		System.out.println("Date of transport : " + gt.getTransportDate());
		System.out.println("Rating of the transport : " + gt.getTransportRating());

		if (objType.equals("BrickTransport")) {
			BrickTransport b = (BrickTransport) gt;
			System.out.println("Quantity of bricks : " + b.getBrickQuantity());
			System.out.println("Brick price : " + b.getBrickPrice());
		}

		if (objType.equals("TimberTransport")) {
			TimberTransport t = (TimberTransport) gt;
			System.out.println("Type of the timber : " + t.getTimberType());
			System.out.println("Timber price per kilo : " + t.getTimberPrice());
		}

		System.out.println("Vehicle for transport : " + gt.vehicleSelection());
		System.out.println("Total charge : " + total);

		sc.close();
	}
}
