package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private String unit;
    private Integer category_id;
    private String img;
    private Long count;
    private Integer price;

    public Product(){}

    public Product(Long id, String name, String unit, Integer category_id, String img, Long count, Integer price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.category_id = category_id;
        this.img = img;
        this.count = count;
        this.price = price;
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

}
