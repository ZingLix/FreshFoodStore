package xyz.zinglix.freshfoodstore.view;

import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.model.Product;

public class InventoryItem {
    Long product_id;
    String name;
    String unit;
    Integer category_id;
    String img;
    Long seller_id;
    Long delivery_id;
    Long price;

    public InventoryItem(Long product_id, String name, String unit, Integer category_id, String img, Long seller_id, Long delivery_id, Long price) {
        this.product_id = product_id;
        this.name = name;
        this.unit = unit;
        this.category_id = category_id;
        this.img = img;
        this.seller_id = seller_id;
        this.delivery_id = delivery_id;
        this.price = price;
    }

    public InventoryItem() {
    }

    public InventoryItem(Inventory i, Product p) {
        this.product_id = i.getProduct_id();
        this.name = p.getName();
        this.unit = p.getUnit();
        this.category_id = p.getCategory_id();
        this.img = p.getImg();
        this.seller_id = i.getSeller_id();
        this.delivery_id = i.getDelivery_id();
        this.price = i.getPrice();
    }


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
