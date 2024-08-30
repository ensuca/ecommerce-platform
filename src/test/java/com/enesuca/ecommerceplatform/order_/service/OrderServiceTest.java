package com.enesuca.ecommerceplatform.order_.service;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import com.enesuca.ecommerceplatform.order_.repository.OrderRepository;
import com.enesuca.ecommerceplatform.order_.repository.OrderItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    private Order_ order;
    private OrderItem orderItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize sample order and order item objects for testing
        order = new Order_();
        order.setId(1L);
        order.setUserId(1L);
        order.setProductId(1L);
        order.setQuantity(10);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setOrderId(1L);
        orderItem.setProductId(1L);
        orderItem.setQuantity(5);
    }

    @Test
    void testCreateOrder() {
        // Mock repository to return the created order
        when(orderRepository.save(any(Order_.class))).thenReturn(order);

        // Create an order and verify the result
        Order_ createdOrder = orderService.createOrder(order, Arrays.asList(orderItem));
        assertNotNull(createdOrder);
        assertEquals(order.getId(), createdOrder.getId());
    }

    @Test
    void testGetOrderById() {
        // Mock repository to return an order by ID
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        // Fetch the order by ID and verify the result
        Optional<Order_> fetchedOrder = orderService.getOrderById(1L);
        assertTrue(fetchedOrder.isPresent());
        assertEquals(order.getId(), fetchedOrder.get().getId());
    }

    @Test
    void testAddOrderItem() {
        // Mock repository to return the added order item
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        // Add an order item and verify the result
        OrderItem addedOrderItem = orderService.addOrderItem(1L, orderItem);
        assertNotNull(addedOrderItem);
        assertEquals(orderItem.getId(), addedOrderItem.getId());
    }

    @Test
    void testRemoveOrderItem() {
        // Perform remove operation and verify the result
        orderService.removeOrderItem(1L, 1L);
        verify(orderItemRepository).deleteById(1L);
    }
}
