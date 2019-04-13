package xyz.zinglix.freshfoodstore.view;

import xyz.zinglix.freshfoodstore.model.Product;
import xyz.zinglix.freshfoodstore.model.UserInfo;
import xyz.zinglix.freshfoodstore.model.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Item{
    Product product;
    Long count;
    Long price;

    public Item(Product product, Long count, Long price) {
        this.product = product;
        this.count = count;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        this.product = p;
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
}

public class OrderDetail {
    Long id;
    Long seller_id;
    UserInfo seller_info;
    Long buyer_id;
    UserInfo buyer_info;
    Long total_price;
    Integer status;
    Date time;
    String address;
    String phone;
    List<Item> products;

    public void setByOrder(Orders o){
        id=o.getId();
        seller_id=o.getSellerId();
        buyer_id=o.getBuyerId();
        total_price=o.getTotalPrice();
        status=o.getStatus();
        time=o.getTime();
        address=o.getAddress();
        phone=o.getPhone();
    }

    public void addItem(Product p,Long count,Long price){
        products.add(new Item(p,count,price));
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public UserInfo getSeller_info() {
        return seller_info;
    }

    public void setSeller_info(UserInfo seller_info) {
        this.seller_info = seller_info;
    }

    public Long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public UserInfo getBuyer_info() {
        return buyer_info;
    }

    public void setBuyer_info(UserInfo buyer_info) {
        this.buyer_info = buyer_info;
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

    public List<Item> getProducts() {
        return products;
    }

    public void setProducts(List<Item> products) {
        this.products = products;
    }

    public OrderDetail() {
        products=new ArrayList<>();
    }
}
