package xyz.zinglix.freshfoodstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    Long id;
    Long orderId;
    @Temporal(TemporalType.TIMESTAMP)
    Date time;
    String info;
    Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Delivery() {
    }

    public Delivery(Long orderId, Date time, String info, Integer status) {
        this.orderId = orderId;
        this.time = time;
        this.info = info;
        this.status = status;
    }
}
