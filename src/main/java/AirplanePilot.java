import java.util.ArrayList;
import java.util.List;

public class AirplanePilot extends Employee {
    private String license;
    private int flightHours;

    public AirplanePilot(String id, String name, String address, String contact, RoleIdentifier role, String numberEmp,
                         String hiringDate, String license, int flightHours){
        super(id,name,address,contact,role,numberEmp,hiringDate);
        this.license = license;
        this.flightHours = flightHours;
    }

    public String getLicense(){
        return license;
    }
    public int getFlightHours(){
        return flightHours;
    }

    public void assignFlight(String flightId){
        System.out.println("Pilot " + getName() + " assigned to flight: " + flightId);
    }

    public void obtainVol(){            //im guessing this is pilot details
        System.out.println("Pilot Details:");
        System.out.println("License: " + license);
        System.out.println("Total Flight Hours: " + flightHours);
    }
}
