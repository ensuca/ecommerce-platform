package com.enesuca.ecommerceplatform.order_.service;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import com.enesuca.ecommerceplatform.order_.repository.OrderItemRepository;
import com.enesuca.ecommerceplatform.order_.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order_> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order_> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order_ createOrder(Order_ order, List<OrderItem> orderItems) {
        Order_ savedOrder = orderRepository.save(order);

        for (OrderItem item : orderItems) {
            item.setOrderId(savedOrder.getId()); // setOrderId kullanımı
            orderItemRepository.save(item);
        }

        return savedOrder;
    }

    public Order_ updateOrder(Long id, Order_ order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(id);
        orderItemRepository.deleteAll(orderItems);

        orderRepository.deleteById(id);
    }

    public <T> Object updateOrder(long eq, T any, List<T> ts) {
        return null;
    }

    public OrderItem addOrderItem(long l, OrderItem orderItem) {
        return null;
    }

    public void removeOrderItem(long l, long l1) {
    }
}
