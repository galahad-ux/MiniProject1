import javax.xml.transform.Source;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("-Airline Management System\n");

        // create
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Pa01", "Aaliyah ULAK", "Lokanthali Bhaktapur, Nepal", "98 61 05 08 56", "PN156165"));
        passengers.add(new Passenger("Pb02", "Anuja KC", "Dallas Texas USA", "44 25 69 75 69", "PN265465"));

        // save
        String filePath = "passengers.csv";
        Passenger.saveAllPassengers(passengers, filePath);

        // loading
        System.out.println("\nLoading the file");
        List<Passenger> loaded = Passenger.loadAllPassengers(filePath);

        // 3. Show
        for (Passenger p : loaded) {
            System.out.println("  • " + p.getName());
        }

        //Testing adding passenger
        Passenger newPassenger = new Passenger("Pc03", "Aryan MULMI", "Dallas, Texas, USA", "44 22 56 88 96", "PN555526");
        passengers.add(newPassenger);
        System.out.println("Added " + newPassenger.getName());
        Passenger.saveAllPassengers(passengers,filePath);
        System.out.println("Saved to CSV");
        List<Passenger>updated = Passenger.loadAllPassengers(filePath);
        for (Passenger p : updated) {
            System.out.println("  • " + p.getName());
        }

        //testing flight

            //data
            Airport a1 = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
            Airport a2 = new Airport("HKG", "Hong Kong", "Chek Lap Kok");

            Aircraft ac1 = new Aircraft("A320-001", "Airbus A320", 180);

            Map<String, Airport> airportMap = new HashMap<>();
            airportMap.put(a1.getName(), a1);
            airportMap.put(a2.getName(), a2);

            Map<String, Aircraft> aircraftMap = new HashMap<>();
            aircraftMap.put(ac1.getRegistration(), ac1);

            //creating flights
            List<Flight> flights = new ArrayList<>();

            Flight f1 = new Flight(
                    "AF129",
                    a1, a2,
                    LocalDateTime.of(2025, 1, 10, 10, 30),
                    LocalDateTime.of(2025, 1, 10, 20, 15),
                    FlightStatus.On_time
            );
            f1.setAircraft(ac1);

            flights.add(f1);

            Flight.saveAllFlights(flights);
            System.out.println(">>> Saved flights to CSV.");

            List<Flight> loadedFlights = Flight.loadAllFlights(airportMap, aircraftMap);
            System.out.println(">>> Loaded flights from CSV.");

            for (Flight f : loadedFlights) {
                System.out.println("Flight: " + f.getFlightNumber());
                System.out.println("  From: " + f.getOrigin().getName());
                System.out.println("  To:   " + f.getDestination().getName());
                System.out.println("  Depart: " + f.getDepartureTime());
                System.out.println("  Arrive: " + f.getArrivalDateTime());
                System.out.println("  Status: " + f.getStatus());
            }
        }


    }
