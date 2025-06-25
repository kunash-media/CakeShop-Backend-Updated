package com.cs.cakeshop.repository;

import com.cs.cakeshop.entity.ProductReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReviewEntity, Long> {
    List<ProductReviewEntity> findByCustomerName(String customerName);
    List<ProductReviewEntity> findByRatings(Integer ratings);
    List<ProductReviewEntity> findByApproval(String approval);
}
