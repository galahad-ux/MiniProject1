import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Aircraft {
    private String registration;
    private String model;
    private int capacity;

    //list of flights
    private List<Flight> givenFlights = new ArrayList<>();

    //constructor
    public Aircraft(String registration, String model, int capacity) {
        this.registration = registration;
        this.model = model;
        this.capacity = capacity;
    }

    //getters
    public String getRegistration() {
        return registration;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Flight> getGivenFlights(){
        return givenFlights;
    }


    //defining methods
    public boolean checkAvailability(LocalDateTime dep, LocalDateTime arr){
        for (Flight f : givenFlights) {
            if (f.overlaps(dep, arr)){
                return false;
            }
        }
        return true;
    }

    public boolean assignFlight(Flight flight) {
        if (!checkAvailability(flight.getDepartureTime(), flight.getArrivalDateTime())) {
            return false;
        }
        givenFlights.add(flight);
        flight.setAircraft(this);
        return true;
    }

    public void updateAircraft(String model, int capacity){
        this.model = model;
        this.capacity = capacity;
    }

    //CSV
    public String toCSV() {
        return registration + "," + model + "," + capacity;
    }

    public static Aircraft fromCSV(String csvLine) {
        String[] o = csvLine.split(",");

        String registration = o[0];
        String model = o[1];
        int capacity = Integer.parseInt(o[2]);

        return new Aircraft(registration, model, capacity);
    }

    public static void saveAllAircraft(List<Aircraft> aircraftList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("aircraft.csv"))) {

            for (Aircraft a : aircraftList) {
                writer.write(a.toCSV());
                writer.newLine();
            }

            System.out.println("Aircraft saved.");
        } catch (IOException e) {
            System.out.println("Error saving aircraft: " + e.getMessage());
        }
    }

    public static List<Aircraft> loadAllAircraft() {
        List<Aircraft> aircraftList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("aircraft.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    aircraftList.add(fromCSV(line));
                }
            }

            System.out.println("Aircraft loaded.");

        } catch (IOException e) {
            System.out.println("Error loading aircraft: " + e.getMessage());
        }

        return aircraftList;
    }

    @Override
    public String toString() {
        return registration + " (" + model + ") - Capacity: " + capacity;
    }

}

