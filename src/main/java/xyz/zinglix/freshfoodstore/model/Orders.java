package xyz.zinglix.freshfoodstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    Long id;
    Long sellerId;
    Long buyerId;
    Long totalPrice;
    Integer status;
    @Temporal(TemporalType.TIMESTAMP)
    Date time;
    String address;
    String phone;

    public Orders() {
    }

    public Orders(Long seller_id, Long buyer_id, Long total_price, Integer status, Date time, String address, String phone) {
        this.sellerId = seller_id;
        this.buyerId = buyer_id;
        this.totalPrice = total_price;
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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
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
