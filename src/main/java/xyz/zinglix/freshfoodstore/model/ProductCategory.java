package xyz.zinglix.freshfoodstore.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer id;
    private String typename;

    public ProductCategory(){}

    public ProductCategory(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public ProductCategory(String typename) {
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }


}
