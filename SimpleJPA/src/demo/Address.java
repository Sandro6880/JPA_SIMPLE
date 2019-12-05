package demo;

import javax.persistence.*;

@Entity
public class Address {

    @EmbeddedId
    private AddressId id;
    private String country;
    private String city;
    private String street;
    private short streetNo;

    public AddressId getId() {
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(short streetNo) {
        this.streetNo = streetNo;
    }
}
