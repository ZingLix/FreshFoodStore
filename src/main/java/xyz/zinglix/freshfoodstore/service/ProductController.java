package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.ProductCategoryRepository;
import xyz.zinglix.freshfoodstore.dao.ProductRepository;
import xyz.zinglix.freshfoodstore.model.Product;
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
}
