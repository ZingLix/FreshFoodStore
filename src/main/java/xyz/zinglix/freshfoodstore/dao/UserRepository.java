package xyz.zinglix.freshfoodstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zinglix.freshfoodstore.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findAllByUsername(String username);
    List<User> findAllByType(Integer type);
}
