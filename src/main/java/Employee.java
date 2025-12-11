import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {
    public String numberEmp;
    private String hiringDate;
    private RoleIdentifier role;

    public Employee(String id, String name, String address, String contact, RoleIdentifier role, String numberEmp, String hiringDate){
        super(id, name, address, contact);
        this.numberEmp = numberEmp;
        this.hiringDate = hiringDate;
        this.role = role;
    }

    public void setNumberEmp(String numberEmp){
        this.numberEmp = numberEmp;
    }

    public void setHiringDate(String hiringDate){
        this.hiringDate = hiringDate;
    }
    public void setRole(RoleIdentifier role){
        this.role = role;
    }

    public String getRole(){
        return "Role: " + role;
    }

    //CSV methods
    public String toCSV(){
        return getId() + "," + getName() + "," + getAddress() + "," + getContact() + "," + role + "," + numberEmp
                + "," + hiringDate;
    }

    public static Employee fromCSV(String csvLine){
        String[] objects = csvLine.split(",");
        RoleIdentifier role = RoleIdentifier.valueOf(objects[4]);
        return new Employee(objects[0], objects[1], objects[2], objects[3], role, objects[5], objects[6]);
    }

    public static void saveAllEmployees(List<Employee> employees ){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.csv"))){
            for (Employee e : employees){
                writer.write(e.toCSV());
                writer.newLine();
            }
            System.out.println("Saved to file");
        } catch (IOException e) {
            System.out.println("Error! can't save employee" + e.getMessage());
        }
    }

    public static List<Employee> loadAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("employee.csv"))){
            String line;
            while((line = reader.readLine()) != null){
                if (!line.trim().isEmpty()){
                    employees.add(fromCSV(line));
                }
            }
            System.out.println("Loaded passenger");
        }catch (IOException e){
            System.out.println("Error! Can't load employees" + e.getMessage());
        }
        return employees;
    }
}
