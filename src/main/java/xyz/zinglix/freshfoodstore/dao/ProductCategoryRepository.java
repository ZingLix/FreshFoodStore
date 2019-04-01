package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.zinglix.freshfoodstore.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findAll();
    Optional<ProductCategory> findById(Integer id);
    ProductCategory save(ProductCategory p);
    void deleteById(Integer id);

}
