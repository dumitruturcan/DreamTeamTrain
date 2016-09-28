package dturcan.Hibernate;

/**
 * Created by dturcan on 9/27/2016.
 */
public class Persons {

    private int personid;
    private String lastname;
    private String firstname;
    private String address;
    private String city;


    public Persons(String lastname, String firstname, String address, String city){

        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.city = city;

    }

    public  int getPersonid() {
        return personid;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }


    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
