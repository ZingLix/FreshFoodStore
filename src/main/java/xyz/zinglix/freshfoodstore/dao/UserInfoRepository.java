package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
}
