import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Aircraft {
    private String registration;
    private String model;
    private int capacity;

    //list of flights
    private List<Flight> givenFlights = new ArrayList<>();

    //constructor
    public Aircraft(String registration, String model, int capacity) {
        this.registration = registration;
        this.model = model;
        this.capacity = capacity;
    }

    //getters
    public String getRegistration() {
        return registration;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Flight> getGivenFlights(){
        return givenFlights;
    }


    //defining methods
    public boolean checkAvailability(LocalDateTime dep, LocalDateTime arr){
        for (Flight f : givenFlights) {
            if (f.overlaps(dep, arr)){
                return false;
            }
        }
        return true;
    }

    public boolean assignFlight(Flight flight) {
        if (!checkAvailability(flight.getDepartureTime(), flight.getArrivalDateTime())) {
            return false;
        }
        givenFlights.add(flight);
        flight.setAircraft(this);
        return true;
    }

    public void updateAircraft(String model, int capacity){
        this.model = model;
        this.capacity = capacity;
    }

}

