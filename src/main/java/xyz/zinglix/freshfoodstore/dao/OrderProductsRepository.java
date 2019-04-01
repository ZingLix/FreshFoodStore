package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.OrderProducts;

public interface OrderProductsRepository extends JpaRepository<OrderProducts,Long> {
}
