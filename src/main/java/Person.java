public class Person {
    private String iD;
    private String name;
    private String address;
    private String contact;

    public Person(String iD, String name, String address, String contact){
        this.iD = iD;
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

    public String getId(){
        return iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInfos(){
        return "ID: " + iD +
                ", Name: " + name +
                ", Address: " + address +
                ", Contact: " + contact;
    }

    @Override
    public String toString(){
        return getInfos();
    }
}
