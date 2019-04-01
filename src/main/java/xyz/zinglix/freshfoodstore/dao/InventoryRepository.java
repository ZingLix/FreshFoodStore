package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
