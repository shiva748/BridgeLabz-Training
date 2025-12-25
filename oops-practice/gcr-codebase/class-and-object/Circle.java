public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void areaCircle() {
		System.out.println("Area of circle: "+(Math.PI*radius*radius));
	}

    public void circumferenceCircle() {
		System.out.println("Circumference of circle: "+(2*Math.PI*radius));
	}
	
    public static void main(String[] args) {
        Circle circle = new Circle(8.6);
        circle.circumferenceCircle();
        circle.areaCircle();
    }
}
