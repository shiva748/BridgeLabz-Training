public class VolumeOfEarth {
    public static void main(String[] args) {
        int radius = 6378;
        System.out.printf("The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f", (double)(4/3*Math.PI*Math.pow(radius, 3)), (double)(4/3*Math.PI*Math.pow(radius*0.621371, 3)));
    }
}
