package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.ProductCategoryRepository;
import xyz.zinglix.freshfoodstore.dao.ProductRepository;
import xyz.zinglix.freshfoodstore.model.Product;
import xyz.zinglix.freshfoodstore.model.ProductCategory;
import xyz.zinglix.freshfoodstore.util.ResourceNotFoundException;

import java.util.List;



@RestController
public class ProductController {
    @Autowired
    private ProductRepository product;

    @Autowired
    private ProductCategoryRepository category;

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
    @GetMapping("/api/products/category")
    public List<ProductCategory> getProductCategory(){
        return category.findAll();
    }

    @CrossOrigin
    @PostMapping("/api/products/category")
    public ProductCategory addProductCategory(@RequestBody ProductCategory c){
        return category.save(c);
    }

    @CrossOrigin
    @GetMapping("/api/products/category/{id}")
    public ProductCategory getProductCategory(@PathVariable Integer id){
        var c=category.findById(id);
        if(c.isPresent()) return c.get();
        else throw new ResourceNotFoundException("Product category "+id+" doesn't exist.");
    }

    @CrossOrigin
    @PutMapping("/api/products/category/{id}")
    public ProductCategory modifyProductCategory(@RequestBody ProductCategory c,@PathVariable Integer id){
        c.setId(id);
        return category.save(c);
    }
    @CrossOrigin
    @DeleteMapping("/api/products/category/{id}")
    public void delProductCategory(@PathVariable Integer id){
        category.deleteById(id);
    }
}
