package xyz.zinglix.freshfoodstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FundLog {
    @Id
    @GeneratedValue
    Long id;
    Long userId;
    @Temporal(TemporalType.TIMESTAMP)
    Date time;
    Integer type;
    Long count;
    Integer reason;
    Long orderId;
    String msg;


    public FundLog(Long userId, Date time, Integer type, Long count, Integer reason, Long orderId, String msg) {
        this.userId = userId;
        this.time = time;
        this.type = type;
        this.count = count;
        this.reason = reason;
        this.orderId = orderId;
        this.msg = msg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FundLog() {
    }

    public FundLog(Long userId, Integer type, Long count, Integer reason, Long orderId, String msg) {
        this.userId = userId;
        this.type = type;
        this.count = count;
        this.reason = reason;
        this.orderId = orderId;
        this.msg = msg;
    }
}
