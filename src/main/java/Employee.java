public class Employee extends Person {
    public String numberEmp;
    private String hiringDate;
    private RoleIdentifier role;

    public Employee(String name, String address, String contact, RoleIdentifier role){
        super(name, address, contact);
        this.role = role;
    }

    public void setNumberEmp(String numberEmp){
        this.numberEmp = numberEmp;
    }

    public void setHiringDate(String hiringDate){
        this.hiringDate = hiringDate;
    }

    public String getRole(){
        return "Role: " + role;
    }
}
