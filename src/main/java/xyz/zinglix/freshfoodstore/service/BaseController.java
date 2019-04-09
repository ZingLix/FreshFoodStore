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
public class BaseController {
    @Autowired
    private BaseInventoryRepository inv;
    @Autowired
    private ProductRepository product;
    @GetMapping("/api/base/inventory")
    @CrossOrigin
    List<BaseInventoryItem> getInventory(){
        return inv.findAllWithProductInfo();
    }

    @PostMapping("/api/base/inventory")
    @CrossOrigin
    BaseInventoryItem addInventory(@RequestBody BaseInventoryItem i){
        Product p=new Product(i.getName(),i.getUnit(),i.getCategory_id(),i.getImg());
        BaseInventory b=new BaseInventory(p.getId(), i.getCount(),i.getPrice());
        p= product.save(p);
        b.setId(p.getId());
        b= inv.save(b);
        return new BaseInventoryItem(b,p);
    }

    @PutMapping("/api/base/inventory/{id}")
    @CrossOrigin
    BaseInventoryItem setInventory(@RequestBody BaseInventoryItem i,@PathVariable Long id){
        var oldb=inv.findById(id);
        if(!oldb.isPresent()) throw new ResourceNotFoundException("inventory id"+id+" doesn't exist.");
        Product p=new Product(id,i.getName(),i.getUnit(),i.getCategory_id(),i.getImg());
        p= product.save(p);
        var newb=oldb.get();
        newb.setCount(i.getCount());
        newb.setPrice(i.getPrice());
        newb= inv.save(newb);
        return new BaseInventoryItem(newb,p);

    }
}
