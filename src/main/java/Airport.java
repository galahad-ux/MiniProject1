import java.util.ArrayList;
import java.util.List;


public class Airport {
    private String name;
    private String city;
    private String description;

    private List<Flight> arrivals = new ArrayList<>();
    private List<Flight> departures = new ArrayList<>();

    public Airport (String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }

    public void assignFlight(Flight flight) {
        if (flight.getOrigin() == this){
            departures.add(flight);
        }
        if (flight.getDestination() == this){
            arrivals.add(flight);
        }
    }

    public List<Flight> getArrivals(){
        return arrivals;
    }
    public List<Flight> getDepartures(){
        return departures;
    }

}
