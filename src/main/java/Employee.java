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

    public String getRoleInfo(){
        return "Role: " + role;
    }
}
