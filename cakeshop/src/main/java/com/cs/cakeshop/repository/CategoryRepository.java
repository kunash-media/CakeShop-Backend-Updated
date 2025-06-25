package com.cs.cakeshop.repository;

import com.cs.cakeshop.entity.Category;
import com.cs.cakeshop.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(CategoryType type);
}

