package com.cs.cakeshop.repository;

import com.cs.cakeshop.entity.Product;
import com.cs.cakeshop.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductType(ProductType productType);

    List<Product> findByIsAvailable(Boolean isAvailable);

    List<Product> findByIsFeatured(Boolean isFeatured);

    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id IN :categoryIds")
    List<Product> findByCategoryIds(@Param("categoryIds") Set<Long> categoryIds);

    @Query("SELECT p FROM Product p WHERE " +
            "(:productType IS NULL OR p.productType = :productType) AND " +
            "(:isAvailable IS NULL OR p.isAvailable = :isAvailable) AND " +
            "(:isFeatured IS NULL OR p.isFeatured = :isFeatured)")
    List<Product> findWithFilters(@Param("productType") ProductType productType,
                                  @Param("isAvailable") Boolean isAvailable,
                                  @Param("isFeatured") Boolean isFeatured);
}
