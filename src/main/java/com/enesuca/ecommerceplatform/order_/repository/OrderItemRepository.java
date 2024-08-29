package com.enesuca.ecommerceplatform.order_.repository;

import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // orderId'ye göre OrderItem'ları bul
    List<OrderItem> findByOrderId(Long orderId);
}
