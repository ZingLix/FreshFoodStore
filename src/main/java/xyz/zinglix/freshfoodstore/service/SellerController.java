package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.BaseInventoryRepository;
import xyz.zinglix.freshfoodstore.dao.ProductRepository;
import xyz.zinglix.freshfoodstore.model.BaseInventory;
import xyz.zinglix.freshfoodstore.model.Product;
import xyz.zinglix.freshfoodstore.util.ResourceNotFoundException;
import xyz.zinglix.freshfoodstore.view.BaseInventoryItem;

import java.util.List;

@RestController
public class SellerController {
    @Autowired
    private BaseInventoryRepository base;

    @GetMapping("/api/seller/baseProducts")
    @CrossOrigin
    List<BaseInventoryItem> getBaseProducts(){
        return base.findAllWithProductInfo();
    }
}
