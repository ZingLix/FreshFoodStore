package xyz.zinglix.freshfoodstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    Long id;
    Long delivery_id;
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

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
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

    public Delivery(Long delivery_id, Date time, String info, Integer status) {
        this.delivery_id = delivery_id;
        this.time = time;
        this.info = info;
        this.status = status;
    }
}
