import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void bookFlight() {
        Passenger p = new Passenger("Pb02", "Anuja KC", "Dallas Texas USA", "44 25 69 75 69", "PN265465");
        Book b = new Book("RE1", p);

        Airport origin = new Airport("Orly", "Paris", "Orly Airport");
        Airport destination = new Airport("Changi", "Singapore", "Singapore Airport");

        Flight flight = new Flight("TEST999", origin, destination,
                LocalDateTime.of(2025, 12, 12, 6, 0),
                LocalDateTime.of(2025, 12, 12, 14, 0),
                FlightStatus.On_time);

        b.bookFlight(flight);

        assertEquals(1, b.getFlights().size());
        assertEquals(flight, b.getFlights().get(0));
    }

    @Test
    void cancelBook() {
        Passenger p = new Passenger("Pb03", "Anuja KC", "Dallas Texas USA", "44 25 69 75 69", "PN265465");
        Book b = new Book("RE2", p);

        b.cancelBook();
        assertEquals(Status.Cancelled, b.getStatus());

    }

    @Test
    void modifyReservation() {
        Passenger p = new Passenger("Pb01", "Anuja KC", "Dallas Texas USA", "44 25 69 75 69", "PN265465");
        Book b = new Book("RE3", p);

        b.modifyReservation(Status.On_Progress);
        assertEquals(Status.On_Progress, b.getStatus());
    }

    @Test
    void getReservations() {
        Passenger p = new Passenger("Pb05", "Aryan", "Dallas Texas USA", "44 25 69 75 69", "PN265465");
        Book b = new Book("RE3", p);

        Airport destination = new Airport("Orly", "Paris", "Orly Airport");
        Airport origin = new Airport("Changi", "Singapore", "Singapore Airport");

        Flight flight = new Flight("OA444215", origin, destination,
                LocalDateTime.of(2026, 1, 12, 6, 0),
                LocalDateTime.of(2026, 1, 12, 14, 0),
                FlightStatus.On_time);

        b.bookFlight(flight);
        String result = b.getReservations();

        assertTrue(result.contains("RE3"));
    }
}