package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fund {
    @Id
    Long id;
    Long count;




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

    public Fund() {
    }

    public Fund(Long count) {
        this.count = count;
    }


}
