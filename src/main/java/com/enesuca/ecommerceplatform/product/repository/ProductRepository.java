package com.enesuca.ecommerceplatform.product.repository;

import com.enesuca.ecommerceplatform.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
