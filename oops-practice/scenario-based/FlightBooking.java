import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    int flightId;
    String source;
    String destination;
    double price;

    Flight(int flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    void display() {
        System.out.println(
            "Flight ID: " + flightId +
            ", From: " + source +
            ", To: " + destination +
            ", Price: " + price
        );
    }
}

public class FlightBooking {

    static Flight[] availableFlights = {
        new Flight(101, "Delhi", "Mumbai", 4500),
        new Flight(102, "Delhi", "Bangalore", 5500),
        new Flight(103, "Mumbai", "Chennai", 4800),
        new Flight(104, "Hyderabad", "Delhi", 5000)
    };

    static List<Flight> bookedFlights = new ArrayList<>();

    static void searchFlights(String source, String destination) {
        boolean found = false;

        for (Flight flight : availableFlights) {
            if (flight.source.equalsIgnoreCase(source) &&
                flight.destination.equalsIgnoreCase(destination)) {
                flight.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found for the given route.");
        }
    }

    static void bookFlight(int flightId) {
        for (Flight flight : availableFlights) {
            if (flight.flightId == flightId) {
                bookedFlights.add(flight);
                System.out.println("Flight booked successfully!");
                return;
            }
        }
        System.out.println("Invalid Flight ID. Booking failed.");
    }

    static void displayBookings() {
        if (bookedFlights.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("Your Booked Flights:");
        for (Flight flight : bookedFlights) {
            flight.display();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    searchFlights(source, destination);
                    break;

                case 2:
                    System.out.print("Enter Flight ID to book: ");
                    int flightId = scanner.nextInt();
                    bookFlight(flightId);
                    break;

                case 3:
                    displayBookings();
                    break;

                case 4:
                    System.out.println("Thank you for using Flight Booking System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
