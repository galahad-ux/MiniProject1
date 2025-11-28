import javax.xml.transform.Source;

public class Main {

    public static void main(String[] args) {

//        Person a = new Person("Aaliyah", "Kathmandu", "061552265");
//        a.setiD("12345");
//        System.out.println(a.getInfos());

        Employee employee = new Employee("Amy", "Newyork", "268432315", RoleIdentifier.Cabin_Crew);
        System.out.println(employee.getRole());
    }
}
