public class Passenger extends Person {
    public String passport;

    public Passenger(String name, String address, String contact, String passport) {
        super(name, address, contact);
        this.passport = passport;
    }

    public String getPassport(){
        return passport;
    }

    public void bookFlight(){

    }
}
