package com.enesuca.ecommerceplatform.order_.repository;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order_, Long> {
}
