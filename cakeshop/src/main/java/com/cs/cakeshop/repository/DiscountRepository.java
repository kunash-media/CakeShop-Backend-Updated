package com.cs.cakeshop.repository;


import com.cs.cakeshop.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {
    Optional<DiscountEntity> findByDiscountCode(String discountCode);
    List<DiscountEntity> findByStatus(String status);
    List<DiscountEntity> findByDiscountType(String discountType);
}
