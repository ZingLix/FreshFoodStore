package xyz.zinglix.freshfoodstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    Long id;
    Long seller_id;
    Long buyer_id;
    Long total_price;
    Integer status;
    @Temporal(TemporalType.TIMESTAMP)
    Date time;
    String address;
    String phone;

    public Orders() {
    }

    public Orders(Long seller_id, Long buyer_id, Long total_price, Integer status, Date time, String address, String phone) {
        this.seller_id = seller_id;
        this.buyer_id = buyer_id;
        this.total_price = total_price;
        this.status = status;
        this.time = time;
        this.address = address;
        this.phone = phone;
    }

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

    public Long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    }
