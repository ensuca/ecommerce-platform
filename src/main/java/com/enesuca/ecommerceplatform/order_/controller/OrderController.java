package com.enesuca.ecommerceplatform.order_.controller;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order_> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order_ createOrder(@RequestBody Order_ order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order_ getOrderById(@PathVariable Long id) {
        Optional<Order_> order = orderService.getOrderById(id);
        return order.orElse(null);
    }

    @PutMapping("/{id}")
    public Order_ updateOrder(@PathVariable Long id, @RequestBody Order_ order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    // Root endpoint
    @GetMapping("/root")
    public String rootEndpoint() {
        return "Order service is running!";
    }
}
