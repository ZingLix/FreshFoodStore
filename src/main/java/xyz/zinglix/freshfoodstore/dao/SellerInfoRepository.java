package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,Long> {
}
