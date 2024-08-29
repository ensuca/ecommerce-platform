package com.enesuca.ecommerceplatform.order_.controller;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order_> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order_ createOrder(@RequestBody Order_ order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order_ getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Order_ updateOrder(@PathVariable Long id, @RequestBody Order_ order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

    // Root endpoint
    @GetMapping("/root")
    public String rootEndpoint() {
        return "Order service is running!";
    }

}
