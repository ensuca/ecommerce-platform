package com.enesuca.ecommerceplatform.order_.service;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order_> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order_> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order_ createOrder(Order_ order) {
        return orderRepository.save(order);
    }

    public Order_ updateOrder(Long id, Order_ order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
