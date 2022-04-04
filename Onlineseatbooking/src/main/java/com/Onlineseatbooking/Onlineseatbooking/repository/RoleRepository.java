package com.Onlineseatbooking.Onlineseatbooking.repository;

import com.Onlineseatbooking.Onlineseatbooking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
