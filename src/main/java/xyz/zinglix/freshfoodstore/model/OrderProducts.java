package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderProducts {
    @Id
    @GeneratedValue
    Long order_id;
    Long product_id;
    Integer count;
    Long price;

    public OrderProducts(Long product_id, Integer count, Long price) {
        this.product_id = product_id;
        this.count = count;
        this.price = price;
    }

    public OrderProducts() {
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
