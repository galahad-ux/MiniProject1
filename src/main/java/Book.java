import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String reservationNumber;
    private Passenger passenger;
    private List<Flight> reservedFlights;
    private Status status;

    public Book(String reservationNumber, Passenger passenger){
        this.reservationNumber = reservationNumber;
        this.passenger = passenger;
        this.reservedFlights = new ArrayList<>();
        this.status = Status.Confirmed;
    }

    public String getReservationNumber() { return reservationNumber; }
    public Passenger getPassenger() { return passenger; }
    public Status getStatus() { return status; }
    public List<Flight> getFlights() { return reservedFlights; }

    public void bookFlight(Flight flight){      //would be confirmReservation()
        this.reservedFlights.add(flight);
        System.out.println("You have booked your flight successfully!");
    }

    public void cancelBook() {
        this.status = Status.Cancelled; // or String
        System.out.println("The flight " + reservationNumber
                + " is cancelled for " + passenger.getName());
    }

     public void modifyReservation(Status newStatus){
        this.status = newStatus;
        System.out.println("Reservation:" + reservationNumber +"is"+ newStatus.name());
     }

    public String getReservations(){
        String reserves = "For ID: " + reservationNumber + "\n";
        reserves += "Booked Flights: \n";

        if (reservedFlights.isEmpty()){
            reserves += "No flights has been reserved.";

        }else{
            for (Flight flight : reservedFlights){
                reserves += "Flight " + flight.getFlightNumber() + "(" + flight.getStatus() + "): "+
                        flight.getOrigin() + "to" + flight.getDestination() + "at " + flight.getDepartureTime() + "\n";
            }
        }
        return reserves;
    }

    //CSV methods
    public String toCSV(){
        String flightNum = "";
        for (Flight f: reservedFlights){
            if (!flightNum.isEmpty()){
                flightNum += ";";           //flights seperated by ;
            }
            flightNum += f.getFlightNumber();
        }
        if (flightNum.isEmpty()){
            flightNum = "None";     //no flights booked
        }
        return reservationNumber + "," + passenger.getId() + "," + flightNum + "," + status;
    }

    public static Book fromCSV(String csvLine, List<Passenger> allBookedPassengers, List<Flight> allFlights){
        String[] objects = csvLine.split(",");
        String reservationId = objects[0];
        String passengerId = objects[1];
        String flightNumbers = objects[2];
        Status status = Status.valueOf(objects[3]);

        //with passengerid we want the passenger and with flight id we want the flight that was booked
        Passenger foundP = null;
        for (Passenger p : allBookedPassengers){
            if (p.getId().equals(passengerId)){
                foundP = p;
                break;
            }
        }

        Book book = new Book(reservationId,foundP);
        System.out.println("booking created for" + passengerId);
        book.modifyReservation(status);
        return book;
    }

    public static void saveAllBooks(List<Book> books){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservations.csv"))){
            for (Book b : books){
                writer.write(b.toCSV());
                writer.newLine();
            }
            System.out.println("Saved the reservations");
        } catch (IOException e) {
            System.out.println("Error! can't save reservation" + e.getMessage());
        }
    }

    public static List<Book> loadAllBooks (List<Passenger> passengers, List<Flight> flights){
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("reservations.csv"))){
            String line;
            while((line = reader.readLine()) != null){
                if (!line.trim().isEmpty()){
                    books.add(fromCSV(line, passengers, flights));
                }
            }
            System.out.println("Loaded reservations from csv");
        }catch (IOException e){
            System.out.println("Error! Can't load reservations from csv" + e.getMessage());
        }
        return books;
    }
}
