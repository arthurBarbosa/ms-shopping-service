package com.abcode.products.repository;

import com.abcode.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.name, p.price, p.productIdentifier, p.description " +
            "FROM Product p" +
            "JOIN Category c ON p.category.id = c.id " +
            "WHERE c.id = :categoryId")
    public List<Product> getProductByCategory(@Param("categoryId") Long categoryId);

    Product findByProductIdentifier(String productIdentifier);
}
