public class Aircraft {
    private String registration;
    private String model;
    private int capacity;

    private List<Flight> flights = New ArrayList<>();

    public Aircraft(String registration, String model, String capacity){
        this.registration = registration;
        this.model = model;
        this.capacity = capacity;
    }


    public String getRegistration(){
        return registration;
    }
    public String getModel(){
        return model;
    }
    public String getCapacity(){
        return capacity;
    }

