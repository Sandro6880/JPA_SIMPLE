package demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItems {

    @Id
    private int order_id;
    private int product_id;
    private int amount;

    public OrderItems(int order_id, int product_id, int amount) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderItems() {
    }
}
