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
        // Arrange
        OrderItem updatedOrderItem = new OrderItem();
        updatedOrderItem.setId(1L);
        updatedOrderItem.setOrderId(1L);
        updatedOrderItem.setProductId(1L);
        updatedOrderItem.setQuantity(10);

        when(orderItemRepository.findById(1L)).thenReturn(Optional.of(orderItem));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(updatedOrderItem);

        // Act
        OrderItem result = orderItemService.updateOrderItem(1L, updatedOrderItem);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(10, result.getQuantity());
        verify(orderItemRepository).findById(1L);
        verify(orderItemRepository).save(any(OrderItem.class));
    }

    @Test
    void testUpdateOrderItemNotFound() {
        // Arrange
        when(orderItemRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        OrderItem result = orderItemService.updateOrderItem(1L, new OrderItem());

        // Assert
        assertNull(result);
        verify(orderItemRepository).findById(1L);
        verify(orderItemRepository, never()).save(any(OrderItem.class));
    }

    @Test
    void testDeleteOrderItem() {
        // Perform delete operation
        orderItemService.deleteOrderItem(1L);

        // Verify that the delete method was called
        verify(orderItemRepository).deleteById(1L);
    }
}
