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
}
