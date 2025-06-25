package com.cs.cakeshop.repository;

import com.cs.cakeshop.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {

    Optional<StaffEntity> findByEmailAddress(String emailAddress);

    List<StaffEntity> findByStatus(String status);

    @Query("SELECT s FROM StaffEntity s WHERE s.fullName LIKE %:name%")
    List<StaffEntity> findByFullNameContaining(@Param("name") String name);

    // Fixed the query - assuming role is a String field, not a separate entity
    List<StaffEntity> findByRole(String role);

    boolean existsByEmailAddress(String emailAddress);

    boolean existsByPhoneNumber(String phoneNumber);
}