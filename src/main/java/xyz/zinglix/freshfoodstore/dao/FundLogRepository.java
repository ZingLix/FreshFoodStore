package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.FundLog;

public interface FundLogRepository extends JpaRepository<FundLog,Long> {
}
