import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    void createAirport() {
        Airport origin = new Airport("Orly", "Paris", "Orly Airport");
        Airport destination = new Airport("Changi", "Singapore", "Singapore Airport");


        assertEquals("Orly",origin.getName());
        assertEquals("Paris",origin.getCity());
        assertEquals("Orly Airport",origin.getDescription());
    }

    void assignFlight(){
        Airport origin = new Airport("Orly", "Paris", "Orly Airport");
        Airport destination = new Airport("Changi", "Singapore", "Singapore Airport");

        Flight flight = new Flight("TEST999", origin, destination,
                LocalDateTime.of(2025, 12, 12, 6, 0),
                LocalDateTime.of(2025, 12, 12, 14, 0),
                FlightStatus.On_time);

        origin.assignFlight(flight);


    }
}