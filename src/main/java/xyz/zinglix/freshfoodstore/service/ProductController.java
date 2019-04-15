package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.InventoryRepository;
import xyz.zinglix.freshfoodstore.dao.ProductCategoryRepository;
import xyz.zinglix.freshfoodstore.dao.ProductRepository;
import xyz.zinglix.freshfoodstore.dao.UserInfoRepository;
import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.model.Product;
import xyz.zinglix.freshfoodstore.model.ProductCategory;
import xyz.zinglix.freshfoodstore.util.ResourceNotFoundException;
import xyz.zinglix.freshfoodstore.view.ProductInventoryInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProductWithMinPrice{
    Long id;
    Long minprice;
    Product product;

    public ProductWithMinPrice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMinprice() {
        return minprice;
    }

    public void setMinprice(Long minprice) {
        this.minprice = minprice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

@RestController
public class ProductController {
    @Autowired
    private ProductRepository product;

    @Autowired
    private UserInfoRepository userinfo;

    @Autowired
    private InventoryRepository inventory;

    @CrossOrigin
    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return product.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/products/{id}")
    public Product getProductsById(@PathVariable Long id){
        var result = product.findById(id);
        if(result.isPresent()) return result.get();
        else throw new ResourceNotFoundException("Product "+ id+" doesn't exist.");
    }

    @CrossOrigin
    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product p){
        return product.save(p);
    }

    @CrossOrigin
    @PutMapping("/api/products/{id}")
    public Product modifyProductById(@RequestBody Product p,@PathVariable Long id){
        p.setId(id);
        return product.save(p);
    }

    @CrossOrigin
    @GetMapping("/api/products/{id}/inventory")
    public List<ProductInventoryInfo> getProductInventory(@PathVariable Long id){

        var invlist= inventory.findAllByProductIdAndCountGreaterThan(id,0L);
        Map<Long,ProductInventoryInfo> map=new HashMap<>();
        for(var inv:invlist){
            var sellerId=inv.getSellerId();
            if(!map.containsKey(sellerId)) {
                map.put(sellerId, new ProductInventoryInfo());
                map.get(sellerId).setSellerId(inv.getSellerId());
                map.get(sellerId).setSellerInfo(userinfo.findById(sellerId).get());
            }
            map.get(sellerId).getInventoryList().add(inv);
        }
        List<ProductInventoryInfo> list=new ArrayList<>();
        for(var p:map.values()) list.add(p);
        return list;
    }

    @GetMapping("/api/products/mainpage")
    public List<ProductWithMinPrice> getProductsWithMinPrice(){
        List<Product> products=product.findAll();
        List<ProductWithMinPrice> res=new ArrayList<>();
        for(var p:products){
            Long minprice=Long.MAX_VALUE;
            List<Inventory> inv=inventory.findAllByProductId(p.getId());
            for(var i:inv){
                if(i.getPrice()!=0&&i.getPrice()<minprice) minprice=i.getPrice();
            }
            ProductWithMinPrice tmp=new ProductWithMinPrice();
            tmp.setId(p.getId());
            tmp.setProduct(p);
            tmp.setMinprice(minprice==Long.MAX_VALUE?0:minprice);
            res.add(tmp);
        }
        return res;

    }
}
