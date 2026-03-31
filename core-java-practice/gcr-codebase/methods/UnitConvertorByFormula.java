
public class UnitConvertorByFormula {

    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheittocelsius = (farhenheit - 32) * 5 / 9;
        return farhenheittocelsius;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsiustofarhenheit = (celsius * 9 / 5) + 32;
        return celsiustofarhenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double poundstokilograms = pounds * 0.453592;
        return poundstokilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilogramstopounds = kilograms * 2.20462;
        return kilogramstopounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallonstoliters = gallons * 3.78541;
        return gallonstoliters;
    }

    public static double convertLitersToGallons(double liters) {
        double literstogallons = liters * 0.264172;
        return literstogallons;
    }
}