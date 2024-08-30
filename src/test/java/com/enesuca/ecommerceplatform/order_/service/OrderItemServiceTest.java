package com.enesuca.ecommerceplatform.order_.service;

import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import com.enesuca.ecommerceplatform.order_.repository.OrderItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemServiceTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemService orderItemService;

    private OrderItem orderItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize sample order item object for testing
        orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setOrderId(1L);
        orderItem.setProductId(1L);
        orderItem.setQuantity(5);
    }

    @Test
    void testGetAllOrderItems() {
        // Mock repository to return a list of order items
        when(orderItemRepository.findAll()).thenReturn(Arrays.asList(orderItem));

        // Get all order items and verify the result
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        assertEquals(1, orderItems.size());
        assertEquals(orderItem.getId(), orderItems.get(0).getId());
    }

    @Test
    void testGetOrderItemById() {
        // Mock repository to return an order item by ID
        when(orderItemRepository.findById(1L)).thenReturn(Optional.of(orderItem));

        // Get order item by ID and verify the result
        Optional<OrderItem> foundOrderItem = orderItemService.getOrderItemById(1L);
        assertTrue(foundOrderItem.isPresent());
        assertEquals(orderItem.getId(), foundOrderItem.get().getId());
    }

    @Test
    void testCreateOrderItem() {
        // Mock repository to return the created order item
        when(orderItemRepository.save(orderItem)).thenReturn(orderItem);

        // Create an order item and verify the result
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
        assertEquals(orderItem.getId(), createdOrderItem.getId());
    }

    @Test
    void testUpdateOrderItem() {
        // Mock repository to return the updated order item
        when(orderItemRepository.save(orderItem)).thenReturn(orderItem);

        // Update an order item and verify the result
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem.getId(), orderItem);
        assertEquals(orderItem.getId(), updatedOrderItem.getId());
    }

    @Test
    void testDeleteOrderItem() {
        // Perform delete operation
        orderItemService.deleteOrderItem(1L);

        // Verify that the delete method was called
        verify(orderItemRepository).deleteById(1L);
    }
}
