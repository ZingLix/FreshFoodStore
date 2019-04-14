package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.Inventory;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findAllBySellerId(Long id);
    List<Inventory> findAllByProductIdAndCountGreaterThan(Long id,Long lowerbound);
}
