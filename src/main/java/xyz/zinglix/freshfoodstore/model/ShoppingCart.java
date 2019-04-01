package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingCart {
    @Id
    Long user_id;
    String content;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ShoppingCart() {
    }

    public ShoppingCart(Long user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
