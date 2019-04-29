package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.FundLog;

import java.util.List;

public interface FundLogRepository extends JpaRepository<FundLog,Long> {
    List<FundLog> findAllByUserId(Long userid);
}
