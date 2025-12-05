import java.util.ArrayList;
import java.util.List;

public class Book {
    private String reservationNumber;
    private Passenger passenger;
    private List<Flight> reservedFlights;
    private Status status;

    public Book(String reservationNumber, Passenger passenger, Status status){
        this.reservationNumber = reservationNumber;
        this.passenger = passenger;
        this.reservedFlights = new ArrayList<>();
        this.status = status;
    }

    public void bookFlight(Flight flight){      //would be confirmReservation()
        this.reservedFlights.add(flight);
        System.out.println("You have booked your flight successfully!");
    }

    public void cancelBookn() {
        this.status = status.Canceled; // or String
        System.out.println("The flight " + flight.getFlightNumber()
                + " is cancelled for " + passenger.getName());
    }

     public void modifyReservation(Status newStatus){
        this.status = newStatus;
        System.out.println("Reservation:" + reservationNumber + newStatus.name());
     }

    public void getReservations(){
        System.out.println("For ID: " + reservationNumber);
        System.out.println("Booked Flights: ");

        if (reservedFlights.isEmpty()){
            System.out.println("No flights has been reserved.");
            return;
        }

        for (Flight flight : reservedFlights){
            System.out.println("Flight " + flight.getFlightNumber() + "(" + flight.getStatus() + "): "+ flight.getOrigin() + "to" + flight.getDestination() + "at " + flight.getDepartureTime() );
        }
    }
}
