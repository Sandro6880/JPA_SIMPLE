package demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AddressId implements Serializable {

    private short addressNo;

    @ManyToOne
    //@JoinColumn( name = "ssn")
    private Person person;

    public short getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(short addressNo) {
        this.addressNo = addressNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressId addressId = (AddressId) o;
        return addressNo == addressId.addressNo &&
                Objects.equals(person, addressId.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressNo, person);
    }
}
