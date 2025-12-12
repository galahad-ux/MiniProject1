import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Passenger extends Person {
    public String passport;
    private List<Book> reservations = new ArrayList<>();

    public Passenger(String id, String name, String address, String contact, String passport) {
        super(id, name, address, contact);
        this.passport = passport;
    }

    public String getPassport(){
        return passport;
    }
    public String getName() {
        return super.getName();
    }
    public String getAddress() {
        return super.getAddress();
    }
    public String getId() {
        return super.getId();
    }
    public String getContact() {
        return super.getContact();
    }

    public Book bookFlight(Flight flight){
        String reservationNumber = UUID.randomUUID().toString();
        Book reservation = new Book(reservationNumber, this);
        reservation.bookFlight(flight);
        reservations.add(reservation);
        System.out.println(getName() + " created reservation " + reservationNumber);
        return reservation;
    }

    public boolean cancelBook(String reservationNumber){
        for (Book book : reservations) {
            if (book.getReservationNumber().equals(reservationNumber)) {
                book.cancelBook();
                return true;
            }
        }
        return false;
    }

    public List<Book> getReservations(){
        return reservations;
    }

    //CSV methods
    public String toCSV(){
        return getId() + "," + getName() + "," + getAddress() + "," + getContact() + "," + passport;
    }

    public static Passenger fromCSV(String csvLine){
        String[] objects = csvLine.split(",");
        return new Passenger(objects[0], objects[1], objects[2], objects[3], objects[4]);
    }

    public static void saveAllPassengers(List<Passenger> passengers, String filepath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passengers.csv"))){
            for (Passenger p : passengers){
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("Saved to file");
        } catch (IOException e) {
            System.out.println("Error! can't save passenger" + e.getMessage());
        }
    }

    public static List<Passenger> loadAllPassengers(String filePath){
        List<Passenger> passengers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("passengers.csv"))){
            String line;
            while((line = reader.readLine()) != null){
                if (!line.trim().isEmpty()){
                    passengers.add(fromCSV(line));
                }
            }
            System.out.println("Loaded passengers:");
        }catch (IOException e){
            System.out.println("Error! Can't load passenger" + e.getMessage());
        }
        return passengers;
    }

    @Override
    public String toString() {
        return super.toString() + ", Passport: " + passport;
    }
}
