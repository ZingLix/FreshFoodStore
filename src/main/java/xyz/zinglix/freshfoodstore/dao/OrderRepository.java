package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
