import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person {
    public String passport;
    private Reservation currentReservation;

    public Passenger(String id, String name, String address, String contact, String passport) {
        super(id, name, address, contact);
        this.passport = passport;
    }

    public String getPassport(){
        return passport;
    }

    public void bookFlight(Flight flight){
        this.currentReservation.bookFlight(flight);
    }

    public void cancelBook(String flightId){
        this.currentReservation.cancelBook(flightId);
    }

    public void getBooks(){
        this.currentReservation.getReservations();
    }

    //CRUD MEthods
    private List<Passenger> passengers = new ArrayList<>();
    //create
    public void addEmployee(Passenger passenger) {
        passengers.add(passenger);
    }

    //read
    public List<Passenger> getAllPassengers() {
        return passengers;
    }

    //update
    public void updatePassenger(Employee updatedPassenger) {

    };

    //delete
    public void deletePassenger(String id){
        passengers.removeIf(passenger -> passenger.getiD().equals(id));
    }
}
