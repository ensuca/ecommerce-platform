package com.enesuca.ecommerceplatform.order_.repository;

import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
