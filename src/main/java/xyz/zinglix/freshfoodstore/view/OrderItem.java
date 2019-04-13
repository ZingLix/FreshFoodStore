package xyz.zinglix.freshfoodstore.view;

public class OrderItem{
    Long id;
    Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItem() {
    }
}
