import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Passenger extends Person {
    public String passport;
    private List<Book> reservations = new ArrayList<>();

    public Passenger(String id, String name, String address, String contact, String passport) {
        super(id, name, address, contact);
        this.passport = passport;
    }

    public String getPassport(){
        return passport;
    }

    public Book bookFlight(Flight flight){
        String reservationNumber = UUID.randomUUID().toString();
        Book reservation = new Book(reservationNumber, this);
        reservation.bookFlight(flight);
        reservations.add(reservation);
        System.out.println(getName() + " created reservation " + reservationNumber);
        return reservation;
    }

    public boolean cancelBook(String reservationNumber){
        for (Book book : reservations) {
            if (book.getReservationNumber().equals(reservationNumber)) {
                book.cancelBook();
                return true;
            }
        }
        return false;
    }

    public List<Book> getReservations(){
        return reservations;
    }
}
