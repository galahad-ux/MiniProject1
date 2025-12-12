import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void testCreatePassenger() {
        Passenger p = new Passenger("Pa01", "Anuja KC", "Dallas Texas USA", "44 25 69 75 69", "PN265465");

        assertEquals("Pa01", p.getId());
        assertEquals("Anuja KC", p.getName());
    }

    @Test
    void bookFlight() {
        Airport paris = new Airport("Orly","Paris","Orly Airport");
        Airport singapore = new Airport("Changi", "Singapore", "Singapore Airport");

        Flight flight = new Flight("TEST999", paris, singapore,
                LocalDateTime.of(2025, 12, 12, 6, 0),
                LocalDateTime.of(2025, 12, 12, 14, 0),
                FlightStatus.On_time);

        Passenger p = new Passenger("Pa02", "Aaliyah ULAK", "Lokanthali Bhaktapur, Nepal", "98 61 05 08 56","PN5615");

        Book b = p.bookFlight(flight);

        assertNotNull(b);
        assertEquals(1,p.getReservations().size());

    }

    @Test
    void cancelBook() {
        Passenger p = new Passenger("Pa02", "Anuja KC", "Lokanthali Bhaktapur, Nepal", "98 61 05 08 56","PN5615");

        Airport paris = new Airport("Orly","Paris","Orly Airport");
        Airport singapore = new Airport("Changi", "Singapore", "Singapore Airport");

        Flight flight = new Flight("TEST999", paris, singapore,
                LocalDateTime.of(2025, 12, 12, 6, 0),
                LocalDateTime.of(2025, 12, 12, 14, 0),
                FlightStatus.On_time);

        Book b = p.bookFlight(flight);
        String reservationNumber = b.getReservationNumber();
        boolean cancelled = p.cancelBook(reservationNumber);
        assertEquals(Status.Cancelled, b.getStatus());
    }
}