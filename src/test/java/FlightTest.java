import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    @Test
    void testCreatingFlights(){
        Airport origin = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport destination = new Airport("HKG", "Hong Kong", "Chek Lap Kok");
        LocalDateTime dt = LocalDateTime.of(2025, 1, 10, 10, 30);
        LocalDateTime at = LocalDateTime.of(2025, 1, 10, 20, 15);

        Flight f = new Flight("AF129", origin, destination,
                LocalDateTime.of(2025, 1, 10, 10, 30),
                LocalDateTime.of(2025, 1, 10, 20, 15), FlightStatus.On_time
        );

        assertEquals("AF129", f.getFlightNumber());
        assertEquals(origin, f.getOrigin());
        assertEquals(destination, f.getDestination());
        assertEquals(dt, f.getDepartureTime());
        assertEquals(at, f.getArrivalDateTime());
        assertEquals(FlightStatus.On_time, f.getStatus());

    }

    @Test
    void overlaps() {
        Airport origin = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport destination = new Airport("HKG", "Hong Kong", "Chek Lap Kok");

        Flight f = new Flight("AF133", origin, destination,
                LocalDateTime.of(2025, 1, 10, 10, 30),
                LocalDateTime.of(2025, 1, 10, 20, 15), FlightStatus.On_time
        );

        LocalDateTime overlapStart = LocalDateTime.of(2025, 1, 10, 11, 30); // overlaps
        LocalDateTime overlapEnd = LocalDateTime.of(2025, 1, 10, 21, 15);

        LocalDateTime nonOverlapStart = LocalDateTime.of(2025, 1, 10, 21, 30); // Doesn't overlap
        LocalDateTime nonOverlapEnd = LocalDateTime.of(2025, 1,11 , 7, 15);

        assertTrue(f.overlaps(overlapStart, overlapEnd));
        assertFalse(f.overlaps(nonOverlapStart, nonOverlapEnd));

    }

    @Test
    void cancelFlight() {
        Airport origin = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport destination = new Airport("HKG", "Hong Kong", "Chek Lap Kok");
        LocalDateTime dt = LocalDateTime.of(2025, 1, 10, 10, 30);
        LocalDateTime at = LocalDateTime.of(2025, 1, 10, 20, 15);

        Flight f = new Flight("AF129", origin, destination,
                LocalDateTime.of(2025, 1, 10, 10, 30),
                LocalDateTime.of(2025, 1, 10, 20, 15), FlightStatus.Delayed
        );

        f.cancelFlight();
        assertEquals(FlightStatus.Canceled, f.getStatus());

    }

    @Test
    void updateFlight() {
        Airport origin = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport destination = new Airport("HKG", "Hong Kong", "Chek Lap Kok");
        LocalDateTime dt = LocalDateTime.of(2025, 1, 10, 10, 30);
        LocalDateTime at = LocalDateTime.of(2025, 1, 10, 20, 15);

        Flight f = new Flight("AF129", origin, destination,
                LocalDateTime.of(2025, 1, 10, 10, 30),
                LocalDateTime.of(2025, 1, 10, 20, 15), FlightStatus.On_time
        );

        //updated time
        LocalDateTime newDt = LocalDateTime.of(2025, 1, 10, 12, 30);
        LocalDateTime newAt = LocalDateTime.of(2025, 1, 10, 22, 15);

        f.updateFlight(newDt, newAt, FlightStatus.Delayed);
        assertEquals(newDt, f.getDepartureTime());
        assertEquals(newAt, f.getArrivalDateTime());
        assertEquals(FlightStatus.Delayed, f.getStatus());

    }
}