package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.Orders;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findAllBySellerId(Long seller_id);
    List<Orders> findAllByBuyerId(Long buyer_id);
    Long countOrdersByBuyerIdAndStatus(Long id,Integer status);
    Long countOrdersBySellerIdAndStatus(Long id,Integer status);
}
