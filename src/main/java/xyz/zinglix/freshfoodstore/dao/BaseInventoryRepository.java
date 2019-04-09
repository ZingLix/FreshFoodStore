package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.zinglix.freshfoodstore.model.BaseInventory;
import xyz.zinglix.freshfoodstore.view.BaseInventoryItem;

import java.util.List;
import java.util.Optional;

public interface BaseInventoryRepository extends JpaRepository<BaseInventory,Long> {
    @Query(value = "SELECT new xyz.zinglix.freshfoodstore.view.BaseInventoryItem(b, p) FROM BaseInventory b,Product p WHERE b.id = p.id")
    List<BaseInventoryItem> findAllWithProductInfo();
    List<BaseInventory> findAll();
    Optional<BaseInventory> findById(Long id);
    BaseInventory save(BaseInventory b);
}