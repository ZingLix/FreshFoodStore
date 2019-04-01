package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.BaseInventory;

import java.util.List;
import java.util.Optional;

public interface BaseInventoryRepository extends JpaRepository<BaseInventory,Long> {

}