package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderProducts {
    @Id
    @GeneratedValue
    Long seqId;
    Long orderId;
    Long productId;
    Long count;
    Long price;

    public OrderProducts(Long product_id, Long count, Long price) {
        this.productId = product_id;
        this.count = count;
        this.price = price;
    }

    public OrderProducts(Long order_id, Long product_id, Long count, Long price) {
        this.orderId = order_id;
        this.productId = product_id;
        this.count = count;
        this.price = price;
    }

    public OrderProducts() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }
}
