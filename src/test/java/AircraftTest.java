import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AircraftTest {
    @Test
    public void createAircraft() {
        Aircraft ac1 = new Aircraft("A320-001", "Airbus A320", 180);

        assertEquals("A320-001", ac1.getRegistration());
        assertEquals("Airbus A320", ac1.getModel());
        assertEquals(180, ac1.getCapacity());
    }

    @Test
    public void assignAircraft(){
        Aircraft ac1 = new Aircraft("A320-001", "Airbus A320", 180);

        Airport origin = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport destination = new Airport("HKG", "Hong Kong", "Chek Lap Kok");

        Flight flight = new Flight("TEST999", origin, destination,
                LocalDateTime.of(2025, 12, 12, 6, 0),
                LocalDateTime.of(2025, 12, 12, 14, 0),
                FlightStatus.On_time);

        boolean assigned = ac1.assignFlight(flight);

        assertTrue(assigned);
        assertEquals(1, ac1.getGivenFlights().size());

    }

    @Test
    public void checkAvailability() {
        Aircraft ac1 = new Aircraft("A320-001", "Airbus A320", 180);

        Airport origin = new Airport("CDG", "Paris", "Charles de Gaulle Airport");
        Airport destination = new Airport("HKG", "Hong Kong", "Chek Lap Kok");

        Flight f = new Flight("AF133", origin, destination,
                LocalDateTime.of(2025, 1, 10, 10, 30),
                LocalDateTime.of(2025, 1, 10, 20, 15), FlightStatus.On_time
        );

        ac1.assignFlight(f);

        LocalDateTime overlapStart = LocalDateTime.of(2025, 1, 10, 11, 30); // overlaps
        LocalDateTime overlapEnd = LocalDateTime.of(2025, 1, 10, 21, 15);

        LocalDateTime nonOverlapStart = LocalDateTime.of(2025, 1, 10, 21, 30); // Doesn't overlap
        LocalDateTime nonOverlapEnd = LocalDateTime.of(2025, 1,11 , 7, 15);

        assertTrue(f.overlaps(overlapStart, overlapEnd));
        assertFalse(f.overlaps(nonOverlapStart, nonOverlapEnd));

    }

    @Test
    public void updateAircraft(){
        Aircraft ac1 = new Aircraft("A320-001", "Airbus A320", 180);
        String newModel = ("Boeing 777");
        int newCapacity = (200);
        ac1.updateAircraft(newModel, newCapacity);

        assertEquals(newModel, ac1.getModel());
        assertEquals(newCapacity, ac1.getCapacity());
    }

}