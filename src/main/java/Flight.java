import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Flight {
    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalDateTime;
    private FlightStatus status;

    private Aircraft aircraft;
    private List<Book> reservations = new ArrayList<>();

    //constructors
    public Flight(String flightNumber, Airport origin, Airport destination, LocalDateTime departureTime,
                  LocalDateTime arrivalDateTime, FlightStatus status) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
    }

    //getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public boolean overlaps(LocalDateTime dep, LocalDateTime arr) {
        return !(arrivalDateTime.isBefore(dep) || departureTime.isAfter(arr));
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }


    //methods
    public void addReservation(Book reservation) { //one flight can be booked by many
        reservations.add(reservation);
    }

    public void planFlight(Airport origin, Airport destination, LocalDateTime dep, LocalDateTime arr, Aircraft a) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = dep;
        this.arrivalDateTime = arr;
        this.status = FlightStatus.On_time;   // or whatever default you chose
        this.aircraft = a;
    }

    public void cancelFlight() {
        this.status = FlightStatus.Canceled;

        for (Book b : reservations) {
            b.modifyReservation(Status.Cancelled);
        }

    }

    public void listingPassengers() {
        System.out.println("Passengers for flight " + flightNumber + ":");

        for (Book b : reservations) {
            Passenger p = b.getPassenger();
            System.out.println("- " + p.getName());
        }
    }

    public void updateFlight(LocalDateTime newDepart, LocalDateTime newArrive, FlightStatus newStat) {
        this.departureTime = newDepart;
        this.arrivalDateTime = newArrive;
        this.status = newStat;
        System.out.println("Flight updated!!");
    }

    //crew assign to flight
    private AirplanePilot pilot;
    private List<StaffCabin> crew = new ArrayList<>();

    public void assignPilot(AirplanePilot pilot) {
        this.pilot = pilot;
    }

    public void assignStaff(StaffCabin staffCabin) {
        crew.add(staffCabin);
    }

    //CSV
    public String toCSV() {
        return flightNumber + "," +
                origin.getName() + "," +
                destination.getName() + "," +
                departureTime.toString() + "," +
                arrivalDateTime.toString() + "," +
                status.name() + "," +
                (aircraft != null ? aircraft.getRegistration() : "");
    }

    public static Flight fromCSV(
            String csvLine,
            Map<String, Airport> airportMap,
            Map<String, Aircraft> aircraftMap
    ) {
        String[] o = csvLine.split(",");

        String flightNumber = o[0];
        Airport origin = airportMap.get(o[1]);
        Airport destination = airportMap.get(o[2]);

        LocalDateTime dep = LocalDateTime.parse(o[3]);
        LocalDateTime arr = LocalDateTime.parse(o[4]);
        FlightStatus status = FlightStatus.valueOf(o[5]);

        Aircraft aircraft = aircraftMap.get(o[6]);

        Flight f = new Flight(flightNumber, origin, destination, dep, arr, status);
        f.setAircraft(aircraft);

        return f;
    }

    public static void saveAllFlights(List<Flight> flights) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("flights.csv"))) {

            for (Flight f : flights) {
                writer.write(f.toCSV());
                writer.newLine();
            }

            System.out.println("Flights saved.");
        } catch (IOException e) {
            System.out.println("Error saving flights: " + e.getMessage());
        }
    }

    public static List<Flight> loadAllFlights(
                Map < String, Airport > airportMap,
                Map < String, Aircraft > aircraftMap
        ){
            List<Flight> flights = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("flights.csv"))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        flights.add(fromCSV(line, airportMap, aircraftMap));
                    }
                }
                System.out.println("Flights loaded.");

            } catch (IOException e) {
                System.out.println("Error loading flights: " + e.getMessage());
            }
            return flights;
        }
}
