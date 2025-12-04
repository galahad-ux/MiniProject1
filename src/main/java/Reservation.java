import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private String reservationId;
    private Passenger passenger;
    private List<Flight> reservedFlights;

    public Reservation(String reservationId, Passenger passenger){
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.reservedFlights = new ArrayList<>();
    }

    public void bookFlight(Flight flight){
        this.reservedFlights.add(flight);
        System.out.println("You have booked your flight successfully!");
    }

    public void cancelBook(String flightId){
        for (int i = 0; i < reservedFlights.size(); i++){
            if (reservedFlights.get(i).getFlightNumber().equals(flightId)){     //checking flight number at i is equal to flight id
                System.out.println("The flight " + flightId + "is cancelled for " + passenger.getName());
                reservedFlights.remove(i);
                return;
            }
        }
    }

    public void getReservations(){
        System.out.println("For ID: " + reservationId);
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
