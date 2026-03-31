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

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }

    public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public float getBrickSize() {
        return brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public String vehicleSelection() {
        if (brickQuantity < 300) return "Truck";
        if (brickQuantity <= 500) return "Lorry";
        return "MonsterLorry";
    }

    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float discountPercent = 0;
        if (transportRating == 5) discountPercent = 20;
        else if (transportRating == 3 || transportRating == 4) discountPercent = 10;

        float discount = price * discountPercent / 100;

        float vehiclePrice = 0;
        String v = vehicleSelection().toLowerCase();
        if (v.equals("truck")) vehiclePrice = 1000;
        else if (v.equals("lorry")) vehiclePrice = 1700;
        else if (v.equals("monsterlorry")) vehiclePrice = 3000;

        return (price + tax + vehiclePrice) - discount;
    }
}

class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    public String vehicleSelection() {
        float area = 2 * 3.147f * timberRadius * timberLength;
        if (area < 250) return "Truck";
        if (area <= 400) return "Lorry";
        return "MonsterLorry";
    }

    public float calculateTotalCharge() {
        float volume = 3.147f * timberRadius * timberRadius * timberLength;

        float rate;
        if (timberType.equalsIgnoreCase("Premium")) rate = 0.25f;
        else rate = 0.15f;

        float price = volume * timberPrice * rate;
        float tax = price * 0.3f;

        float discountPercent = 0;
        if (transportRating == 5) discountPercent = 20;
        else if (transportRating == 3 || transportRating == 4) discountPercent = 10;

        float discount = price * discountPercent / 100;

        float vehiclePrice = 0;
        String v = vehicleSelection().toLowerCase();
        if (v.equals("truck")) vehiclePrice = 1000;
        else if (v.equals("lorry")) vehiclePrice = 1700;
        else if (v.equals("monsterlorry")) vehiclePrice = 3000;

        return (price + tax + vehiclePrice) - discount;
    }
}

class Utility {
    public GoodsTransport parseDetails(String input) {
        String[] d = input.split(":");

        String transportId = d[0];
        String transportDate = d[1];
        int transportRating = Integer.parseInt(d[2]);
        String transportType = d[3];

        if (transportType.equalsIgnoreCase("BrickTransport")) {
            float brickSize = Float.parseFloat(d[4]);
            int brickQty = Integer.parseInt(d[5]);
            float brickPrice = Float.parseFloat(d[6]);
            return new BrickTransport(transportId, transportDate, transportRating, brickSize, brickQty, brickPrice);
        }

        if (transportType.equalsIgnoreCase("TimberTransport")) {
            float timberLength = Float.parseFloat(d[4]);
            float timberRadius = Float.parseFloat(d[5]);
            String timberType = d[6];
            float timberPrice = Float.parseFloat(d[7]);
            return new TimberTransport(transportId, transportDate, transportRating, timberLength, timberRadius, timberType, timberPrice);
        }

        return null;
    }

    public boolean validateTransportId(String transportId) {
        if (!transportId.matches("RTS[0-9]{3}[A-Z]")) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        return true;
    }

    public String findObjectType(GoodsTransport gt) {
        if (gt instanceof TimberTransport) return "TimberTransport";
        if (gt instanceof BrickTransport) return "BrickTransport";
        return null;
    }
}

public class FutureLogistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        GoodsTransport gt = util.parseDetails(input);

        if (!util.validateTransportId(gt.getTransportId())) {
            System.out.println("Please provide a valid record");
            return;
        }

        String type = util.findObjectType(gt);

        if (type.equals("BrickTransport")) {
            BrickTransport bt = (BrickTransport) gt;
            float total = bt.calculateTotalCharge();

            System.out.println("Transporter id : " + bt.getTransportId());
            System.out.println("Date of transport : " + bt.getTransportDate());
            System.out.println("Rating of the transport : " + bt.getTransportRating());
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
            System.out.println("Vehicle for transport : " + bt.vehicleSelection());
            System.out.println("Total charge : " + total);
        }

        if (type.equals("TimberTransport")) {
            TimberTransport tt = (TimberTransport) gt;
            float total = tt.calculateTotalCharge();

            System.out.println("Transporter id : " + tt.getTransportId());
            System.out.println("Date of transport : " + tt.getTransportDate());
            System.out.println("Rating of the transport : " + tt.getTransportRating());
            System.out.println("Type of the timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
            System.out.println("Vehicle for transport : " + tt.vehicleSelection());
            System.out.println("Total charge : " + total);
        }
    }
}
