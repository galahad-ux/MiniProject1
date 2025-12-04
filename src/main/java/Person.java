public class Person {
    private String iD;
    private String name;
    private String address;
    private String contact;

    public Person(String iD, String name, String address, String contact){
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getContact(){
        return contact;
    }

    public void setiD(String iD){
        this.iD=iD;
    }

    public String getInfos(){
        return "ID: " + iD +
                ", Name: " + name +
                ", Address: " + address +
                ", Contact: " + contact;
    }

}
