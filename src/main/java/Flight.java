import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
                  LocalDateTime arrivalDateTime, FlightStatus status){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
    }

    //getters
    public String getFlightNumber(){
        return flightNumber;
    }
    public Airport getOrigin(){
        return origin;
    }
    public Airport getDestination(){
        return destination;
    }
    public LocalDateTime getDepartureTime(){
        return departureTime;
    }
    public FlightStatus getStatus(){
        return status;
    }
    public LocalDateTime getArrivalDateTime(){
        return arrivalDateTime;
    }
    public boolean overlaps(LocalDateTime dep, LocalDateTime arr) {
        return false;
    }
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }


    //methods
    public void addReservation(Book reservation) { //one flight can be booked by many
        reservations.add(reservation);
    }
    public void planFlight(Airport origin, Airport destination, LocalDateTime dep, LocalDateTime arr, Aircraft a){
        this.origin = origin;
        this.destination = destination;
        this.departureTime = dep;
        this.arrivalDateTime = arr;
        this.status = FlightStatus.On_time;   // or whatever default you chose
        this.aircraft = a;
    }
    public void cancelFlight(){
        this.status = FlightStatus.Canceled;

        for (Book b: reservations){
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

}
