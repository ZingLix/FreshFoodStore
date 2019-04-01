package xyz.zinglix.freshfoodstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FundLog {
    @Id
    @GeneratedValue
    Long id;
    Long user_id;
    @Temporal(TemporalType.TIMESTAMP)
    Date time;
    Integer type;
    Long count;
    Integer reason;
    Long order_id;
    String msg;


    public FundLog(Long user_id, Date time, Integer type, Long count, Integer reason, Long order_id, String msg) {
        this.user_id = user_id;
        this.time = time;
        this.type = type;
        this.count = count;
        this.reason = reason;
        this.order_id = order_id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FundLog() {
    }

    public FundLog(Long user_id, Integer type, Long count, Integer reason, Long order_id, String msg) {
        this.user_id = user_id;
        this.type = type;
        this.count = count;
        this.reason = reason;
        this.order_id = order_id;
        this.msg = msg;
    }
}
