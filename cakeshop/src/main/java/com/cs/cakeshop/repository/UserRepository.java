package com.cs.cakeshop.repository;


import com.cs.cakeshop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserId(String userId);
    Users findByUserId(String userId);
}
