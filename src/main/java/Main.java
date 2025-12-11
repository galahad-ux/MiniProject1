import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("-Airline Management System\n");

        // create
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Pa01", "Aaliyah ULAK", "Lokanthali Bhaktapur, Nepal", "98 61 05 08 56", "PN156165"));
        passengers.add(new Passenger("Pb02", "Anuja KC", "Dallas Texas USA", "44 25 69 75 69", "PN265465"));

        // save
        String filePath = "passengers.csv";
        Passenger.saveAllPassengers(passengers, filePath);

        // loading
        System.out.println("\nLoading the file");
        List<Passenger> loaded = Passenger.loadAllPassengers(filePath);

        // 3. Show
        for (Passenger p : loaded) {
            System.out.println("  • " + p.getName());
        }

        //Testing adding passenger
        Passenger newPassenger = new Passenger("Pc03", "Aryan MULMI", "Dallas, Texas, USA", "44 22 56 88 96", "PN555526");
        passengers.add(newPassenger);
        System.out.println("Added " + newPassenger.getName());
        Passenger.saveAllPassengers(passengers,filePath);
        System.out.println("Saved to CSV");
        List<Passenger>updated = Passenger.loadAllPassengers(filePath);
        for (Passenger p : updated) {
            System.out.println("  • " + p.getName());
        }

    }
}
