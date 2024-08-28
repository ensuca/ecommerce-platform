package com.enesuca.ecommerceplatform.order.repository;

import com.enesuca.ecommerceplatform.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
