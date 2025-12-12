import javax.xml.transform.Source;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Flight> flights = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--------- Tribhuwan International Airport--------");
        SimulationData();
        boolean running = true;
        while (running) {
            System.out.println("\n= MAIN MENU");
            System.out.println("1. Flights");
            System.out.println("2. View My Bookings");
            System.out.println("3. Modify My Booking");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> Flights();
                case 2 -> viewBookings();
                case 3 -> modifyBooking();
                case 4 -> {
                    running = false;
                    System.out.println("See you Soon!");
                }
                default -> System.out.println("Invalid!");
            }
        }
        scanner.close();
    }

    private static void SimulationData() {
        //airports
        Airport a1 = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport a2 = new Airport("HKG", "HongKong", "Chek Lap Kok");
        Airport a3 = new Airport("Changi", "Singapore", "Changi Singapore Airport");

        //aircrafts
        Aircraft ac1 = new Aircraft("A320-001", "Airbus A320", 180);
        Aircraft ac2 = new Aircraft("B300-001", "Boeing 777", 200);

        //flights
        Flight f1 = new Flight("AF128", a1, a2,
                LocalDateTime.of(2025, 12, 21, 11, 30),
                LocalDateTime.of(2025, 12, 22, 6, 10), FlightStatus.On_time);

        Flight f2 = new Flight("CX502", a2, a3,
                LocalDateTime.of(2026, 1, 22, 9, 45),
                LocalDateTime.of(2026, 1, 22, 13, 15), FlightStatus.On_time);

        Flight f3 = new Flight(
                "SQ333", a3, a1,
                LocalDateTime.of(2026, 1, 23, 0, 30),
                LocalDateTime.of(2026, 1, 23, 8, 05), FlightStatus.On_time);
        Flight f4 = new Flight(
                "PO463", a1, a3,
                LocalDateTime.of(2026, 2, 23, 0, 30),
                LocalDateTime.of(2026, 2, 23, 8, 05), FlightStatus.On_time);

        f1.setAircraft(ac1);
        f2.setAircraft(ac2);
        f3.setAircraft(ac1);

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);

        //passenger
        passengers.add(new Passenger("Pb02", "Amy", "NewYork USA", "44 25 69 75 69", "PN265465"));
    }

    private static Passenger newPassenger() {
        System.out.println("\n-NEW PASSENGER:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Passport: ");
        String passport = scanner.nextLine();

        System.out.print("Contact: ");
        String contact = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        String id = "P" + String.format("%03d", passengers.size() + 1);
        return new Passenger(id, name, address, contact, passport);
    }

    private static void bookFlight(Flight flight) {
        System.out.println("\n-BOOK FLIGHT " + flight.getFlightNumber());

        System.out.println("Select passenger:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println((i+1) + ". " + passengers.get(i).getName());
        }
        System.out.println((passengers.size() + 1) + ". New passenger");

        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Passenger passenger;
        if (choice == passengers.size() + 1) {
            passenger = newPassenger();
            passengers.add(passenger);
        } else if (choice > 0 && choice <= passengers.size()) {
            passenger = passengers.get(choice - 1);
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        Book reservation = passenger.bookFlight(flight);
        flight.addReservation(reservation);

        System.out.println("\n BOOKING CONFIRMED:) See your details below!");
        System.out.println("Reservation: " + reservation.getReservationNumber());
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Flight: " + flight.getFlightNumber());
        System.out.println("Route: " + flight.getOrigin().getName() + " to " + flight.getDestination().getName());
    }

    private static void Flights(){
        System.out.println("\n-SEARCH FLIGHTS:");

        System.out.print("From (Paris, HongKong, Singapore): ");
        String from = scanner.nextLine().toUpperCase();

        System.out.print("To (Paris, HongKong, Singapore): ");
        String to = scanner.nextLine().toUpperCase();

        System.out.println("\n -> AVAILABLE FLIGHTS: ");
        List<Flight> results = new ArrayList<>();

        for (Flight f : flights) {
            boolean match = true;

            if (!from.isEmpty() && !f.getOrigin().getCity().equalsIgnoreCase(from)) {
                match = false;
            }
            if (!to.isEmpty() && !f.getDestination().getCity().equalsIgnoreCase(to)) {
                match = false;
            }
            if (match) {
                results.add(f);
                System.out.println((results.size()) + ". " + f.getFlightNumber() +
                        " | " + f.getOrigin().getName() + " to " + f.getDestination().getName() +
                        " at " + f.getDepartureTime().toLocalTime() +
                        " | Status: " + f.getStatus());
            }
        }
        if (results.isEmpty()) {
            System.out.println("No flights found. Directing to main");
            return;
        }

        System.out.print("\nBook a flight? Enter 1 (or 0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= results.size()) {
            Flight selected = results.get(choice - 1);
            bookFlight(selected);
        }
    }

    private static void viewBookings(){

    }

    private static void modifyBooking(){

    }
}
