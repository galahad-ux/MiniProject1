import java.util.ArrayList;
import java.util.List;

public class Book {
    private String reservationNumber;
    private Passenger passenger;
    private List<Flight> reservedFlights;

    public Book(String reservationNumber, Passenger passenger){
        this.reservationNumber = reservationNumber;
        this.passenger = passenger;
        this.reservedFlights = new ArrayList<>();
    }

    public void bookFlight(Flight flight){      //would be confirmReservation()
        this.reservedFlights.add(flight);
        System.out.println("You have booked your flight successfully!");
    }

    public void cancelBook(String flightId){        //would be cancelReservation()
        for (int i = 0; i < reservedFlights.size(); i++){
            if (reservedFlights.get(i).getFlightNumber().equals(flightId)){     //checking flight number at i is equal to flight id
                System.out.println("The flight " + flightId + "is cancelled for " + passenger.getName());
                reservedFlights.remove(i);
                return;
            }
        }
    }

    //modifyReservation() to be added

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
