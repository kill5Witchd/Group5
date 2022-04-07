package com.Onlineseatbooking.Onlineseatbooking.repository;

import com.Onlineseatbooking.Onlineseatbooking.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    //Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

//    @Query("SELECT c FROM users c WHERE c.email = ?1")
//    User findByEmail(String email);
//
//    User findByResetPasswordToken(String token);


}
