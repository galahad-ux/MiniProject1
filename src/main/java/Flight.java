public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalDateTime;
    private String status;

    public Flight(String flightNumber, String origin, String destination, String departureTime, String arrivalDateTime, String status){
        flightNumber = this.flightNumber;
        origin = this.origin;
        destination = this.destination;
        departureTime = this.departureTime;
        arrivalDateTime = this.arrivalDateTime;
        status = this.status;
    }

    public

    public String getFlightNumber(){
        return flightNumber;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public String getDepartureTime(){
        return departureTime;
    }
    public String getStatus(){
        return status;
    }
}
