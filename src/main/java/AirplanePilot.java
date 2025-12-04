import java.util.ArrayList;
import java.util.List;

public class AirplanePilot extends Employee {
    private String license;
    private int flightHours;

    public AirplanePilot(String id, String name, String address, String contact, RoleIdentifier role, String numberEmp, String hiringDate, String license, int flightHours){
        super(id,name,address,contact,role,numberEmp,hiringDate);
        this.license = license;
        this.flightHours = flightHours;
    }

    public void assignFlight(String flightId){
        System.out.println("Pilot " + getName() + " assigned to flight: " + flightId);
    }

    public void obtainVol(){            //im guessing this is pilot details
        System.out.println("Pilot Details:");
        System.out.println("License: " + license);
        System.out.println("Total Flight Hours: " + flightHours);
    }

    //CRUD MEthods
    private List<AirplanePilot> airplanePilots = new ArrayList<>();
    //create
    public void addPilot(AirplanePilot airplanePilot) {
        airplanePilots.add(airplanePilot);
    }

    //read
    public List<AirplanePilot> getAllPilots() {
        return airplanePilots;
    }

    //update
    public void updatePilots(AirplanePilot updatedPilot) {

    };

    //delete
    public void deletePilot(String id){
        airplanePilots.removeIf(pilot -> pilot.getiD().equals(id));
    }
}
