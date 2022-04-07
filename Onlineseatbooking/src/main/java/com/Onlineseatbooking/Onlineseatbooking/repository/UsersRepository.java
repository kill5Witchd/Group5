//package com.Onlineseatbooking.Onlineseatbooking.repository;
//
//import com.Onlineseatbooking.Onlineseatbooking.model.User;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//public interface UsersRepository extends CrudRepository<User, Integer> {
//
//    @Query("SELECT c FROM users c WHERE c.email = ?1")
//    public User findByEmail(String email);
//
//    public User findByResetPasswordToken(String token);
//
//    @Entity
//    @Table(name = "users")
//    public class Customer {
//
//        @Column(name = "reset_password_token")
//        private String resetPasswordToken;
//
//    }
//
//}