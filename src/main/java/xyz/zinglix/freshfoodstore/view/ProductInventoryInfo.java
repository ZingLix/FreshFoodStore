package xyz.zinglix.freshfoodstore.view;

import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.model.User;
import xyz.zinglix.freshfoodstore.model.UserInfo;

import java.util.ArrayList;
import java.util.List;


public class ProductInventoryInfo {
    Long sellerId;
    UserInfo sellerInfo;
    List<Inventory> inventoryList;

    public ProductInventoryInfo() {
        inventoryList=new ArrayList<>();
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public UserInfo getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(UserInfo sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
