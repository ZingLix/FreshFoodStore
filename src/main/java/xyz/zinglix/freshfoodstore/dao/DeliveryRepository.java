package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
