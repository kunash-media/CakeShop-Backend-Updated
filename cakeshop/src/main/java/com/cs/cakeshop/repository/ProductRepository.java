package com.cs.cakeshop.repository;

import com.cs.cakeshop.entity.ProductEntity;
import com.cs.cakeshop.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByType(ProductType type);
    List<ProductEntity> findByProductNameContainingIgnoreCase(String productName);
    List<ProductEntity> findByRatingsGreaterThanEqual(Double ratings);
}
