package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.zinglix.freshfoodstore.model.OrderProducts;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProducts,Long> {
    List<OrderProducts> findAllByOrderId(Long order_id);
}
