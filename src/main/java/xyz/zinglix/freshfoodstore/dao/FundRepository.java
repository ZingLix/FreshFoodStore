package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.Fund;

public interface FundRepository extends JpaRepository<Fund,Long> {
}
