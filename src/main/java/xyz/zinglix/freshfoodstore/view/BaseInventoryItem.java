package xyz.zinglix.freshfoodstore.view;

import xyz.zinglix.freshfoodstore.model.BaseInventory;
import xyz.zinglix.freshfoodstore.model.Product;

public class BaseInventoryItem {
    Long id;
    private String name;
    private String unit;
    private Integer category_id;
    private String img;
    Long count;
    Long price;

    public BaseInventoryItem() {
    }

    public BaseInventoryItem(BaseInventory b){
        this.id=b.getId();
        count=b.getCount();
        price=b.getPrice();
    }
    public BaseInventoryItem(Product p){
        this.id=p.getId();
        name=p.getName();
        unit=p.getUnit();
        category_id=p.getCategory_id();
        img=p.getImg();
    }
    public BaseInventoryItem(BaseInventory b,Product p){
        this.id=p.getId();
        count=b.getCount();
        price=b.getPrice();
        name=p.getName();
        unit=p.getUnit();
        category_id=p.getCategory_id();
        img=p.getImg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
