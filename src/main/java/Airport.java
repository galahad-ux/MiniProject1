import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Airport {
    private String name;
    private String city;
    private String description;

    private List<Flight> arrivals = new ArrayList<>();
    private List<Flight> departures = new ArrayList<>();

    //constructors
    public Airport (String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }
    //methods
    public void assignFlight(Flight flight) {
        if (this.equals(flight.getOrigin())) {
            departures.add(flight);
        }
        if (this.equals(flight.getDestination())) {
            arrivals.add(flight);
        }
    }

    //getters
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public List<Flight> getArrivals(){
        return arrivals;
    }
    public List<Flight> getDepartures(){
        return departures;
    }

    //csv
    public String toCSV() {
        return name + "," + city + "," + description;
    }

    public static Airport fromCSV(String csvLine) {
        String[] o = csvLine.split(",");

        String name = o[0];
        String city = o[1];
        String description = o[2];

        return new Airport(name, city, description);
    }

    public static void saveAllAirports(List<Airport> airports) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("airports.csv"))) {

            for (Airport a : airports) {
                writer.write(a.toCSV());
                writer.newLine();
            }

            System.out.println("Airports saved.");

        } catch (IOException e) {
            System.out.println("Error saving airports: " + e.getMessage());
        }
    }

    public static List<Airport> loadAllAirports() {
        List<Airport> airports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("airports.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    airports.add(fromCSV(line));
                }
            }

            System.out.println("Airports loaded.");

        } catch (IOException e) {
            System.out.println("Error loading airports: " + e.getMessage());
        }

        return airports;
    }

}
