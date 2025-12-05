import java.util.ArrayList;
import java.util.List;

public class Book {
    private String reservationNumber;
    private Passenger passenger;
    private List<Flight> reservedFlights;
    private Status status;

    public Book(String reservationNumber, Passenger passenger){
        this.reservationNumber = reservationNumber;
        this.passenger = passenger;
        this.reservedFlights = new ArrayList<>();
        this.status = Status.Confirmed;
    }

    public String getReservationNumber() { return reservationNumber; }
    public Passenger getPassenger() { return passenger; }
    public Status getStatus() { return status; }
    public List<Flight> getFlights() { return reservedFlights; }

    public void bookFlight(Flight flight){      //would be confirmReservation()
        this.reservedFlights.add(flight);
        System.out.println("You have booked your flight successfully!");
    }

    public void cancelBook() {
        this.status = Status.Cancelled; // or String
        System.out.println("The flight " + reservationNumber
                + " is cancelled for " + passenger.getName());
    }

     public void modifyReservation(Status newStatus){
        this.status = newStatus;
        System.out.println("Reservation:" + reservationNumber +"is"+ newStatus.name());
     }

    public void getReservations(){
        System.out.println("For ID: " + reservationNumber);
        System.out.println("Booked Flights: ");

        if (reservedFlights.isEmpty()){
            System.out.println("No flights has been reserved.");
            return;
        }else{
            for (Flight flight : reservedFlights){
                System.out.println("Flight " + flight.getFlightNumber() + "(" + flight.getStatus() + "): "+
                        flight.getOrigin() + "to" + flight.getDestination() + "at " + flight.getDepartureTime() );
            }
        }
    }
}
