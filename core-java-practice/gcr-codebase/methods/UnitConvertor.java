public class UnitConvertor {
    private static final double Km_To_Miles = 0.621371;
    private static final double Miles_To_Km = 1.60934;
    private static final double Meters_To_Feet = 3.28084;
    private static final double Feet_To_Meters = 0.3048;

    public static double convertKmToMiles(double km) {
        return km * Km_To_Miles;
    }

    public static double convertMilesToKm(double miles) {
        return miles * Miles_To_Km;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * Meters_To_Feet;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * Feet_To_Meters;
    }
}