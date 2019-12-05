package demo;

import org.hibernate.annotations.Table;
import org.jetbrains.annotations.Contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class OrderW {

    @Id
    private int id;
    private String ssn;
    private short address_no;
    private Date order_date;

    @Contract(pure = true)
    public OrderW() {

    }

    @Contract(pure = true)
    public OrderW(String ssn, short address_no, Date order_date, short order_state) {
        this.ssn = ssn;
        this.address_no = address_no;
        this.order_date = order_date;
        this.order_state = order_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public short getAddress_no() {
        return address_no;
    }

    public void setAddress_no(short address_no) {
        this.address_no = address_no;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public short getOrder_state() {
        return order_state;
    }

    public void setOrder_state(short order_state) {
        this.order_state = order_state;
    }

    private short order_state;

}

