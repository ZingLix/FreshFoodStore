package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
