package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
