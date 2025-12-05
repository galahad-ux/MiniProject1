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
    public List<Flight> getArrivals(){
        return arrivals;
    }
    public List<Flight> getDepartures(){
        return departures;
    }

}
