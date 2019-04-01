package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    @GeneratedValue
    Long id;
    Long seller_id;
    Long product_id;
    Integer count;
    Long price;
    Long delivery_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
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

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
    }

    public Inventory(Long seller_id, Long product_id, Integer count, Long price, Long delivery_id) {
        this.seller_id = seller_id;
        this.product_id = product_id;
        this.count = count;
        this.price = price;
        this.delivery_id = delivery_id;
    }

    public Inventory() {
    }
}
