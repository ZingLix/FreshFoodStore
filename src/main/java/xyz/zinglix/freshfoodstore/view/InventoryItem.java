package xyz.zinglix.freshfoodstore.view;

import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryItem {
    Long product_id;
    Product product;
    List<Inventory> inventoryList;

    public InventoryItem(){
        inventoryList=new ArrayList<>();
    }

    public InventoryItem(Long product_id) {
        inventoryList=new ArrayList<>();
        this.product_id = product_id;
    }

    public InventoryItem(Long product_id, Product product) {
        inventoryList=new ArrayList<>();
        this.product_id = product_id;
        this.product = product;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public void add(Inventory inv){
        inventoryList.add(inv);
    }
}
