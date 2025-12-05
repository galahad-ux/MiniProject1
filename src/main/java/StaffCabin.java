import java.util.ArrayList;
import java.util.List;

public class StaffCabin extends Employee{
    String qualification;
    public StaffCabin(String id, String name, String address, String contact, RoleIdentifier role, String numberEmp, String hiringDate, String qualification){
        super(id,name,address,contact,role,numberEmp,hiringDate);
        this.qualification = qualification;
    }

    public void assignFlight(String flightId){
        System.out.println("Staff Cabin " + getName() + " assigned to flight: " + flightId);
    }

    public void obtainVol(){
        System.out.println("Staff Cabin Details:");
        System.out.println("Qualification: " + qualification);
    }

    //CRUD MEthods
    private List<StaffCabin> staffCabins = new ArrayList<>();
    //create
    public void addStaffCabin(StaffCabin staffCabin) {
        staffCabins.add(staffCabin);
    }

    //read
    public List<StaffCabin> getAllCabinStaffs() {
        return staffCabins;
    }

    //update
    public void updateCabinStaffs(StaffCabin staffCabin) {

    };

    //delete
    public void deleteStaffCabin(String id){
        staffCabins.removeIf(staff -> staff.getId().equals(id));
    }
}
