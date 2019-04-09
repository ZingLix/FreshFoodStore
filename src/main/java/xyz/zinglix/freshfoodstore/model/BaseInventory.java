package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BaseInventory {
    @Id
            @GeneratedValue
    Long seqid;

    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    public BaseInventory(Long seqid, Long id, Long count, Long price) {
        this.seqid = seqid;
        this.id = id;
        this.count = count;
        this.price = price;
    }

    Long id;
    Long count;
    Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BaseInventory(Long count, Long price) {
        this.count = count;
        this.price = price;
    }

    public BaseInventory(Long id, Long count, Long price) {
        this.id = id;
        this.count = count;
        this.price = price;
    }

    public BaseInventory() {
    }
}
