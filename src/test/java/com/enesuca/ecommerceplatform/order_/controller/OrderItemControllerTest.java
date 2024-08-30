package com.enesuca.ecommerceplatform.order_.controller;

import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import com.enesuca.ecommerceplatform.order_.service.OrderItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderItemService orderItemService;

    @InjectMocks
    private OrderItemController orderItemController;

    private OrderItem orderItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderItemController).build();

        // Initialize sample order item object for testing
        orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setOrderId(1L);
        orderItem.setProductId(1L);
        orderItem.setQuantity(5);
    }

    @Test
    void testGetAllOrderItems() throws Exception {
        // Mock service to return a list of order items
        when(orderItemService.getAllOrderItems()).thenReturn(Arrays.asList(orderItem));

        // Perform GET request and verify the result
        mockMvc.perform(get("/order-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(orderItem.getId()));
    }

    @Test
    void testCreateOrderItem() throws Exception {
        // Mock service to return the created order item
        when(orderItemService.createOrderItem(any(OrderItem.class))).thenReturn(orderItem);

        // Perform POST request and verify the result
        mockMvc.perform(post("/order-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderId\":1,\"productId\":1,\"quantity\":5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderItem.getId()));
    }

    @Test
    void testGetOrderItemById() throws Exception {
        // Mock service to return an order item by ID
        when(orderItemService.getOrderItemById(1L)).thenReturn(Optional.of(orderItem));

        // Perform GET request and verify the result
        mockMvc.perform(get("/order-items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderItem.getId()));
    }

    @Test
    void testUpdateOrderItem() throws Exception {
        // Mock service to return the updated order item
        when(orderItemService.updateOrderItem(eq(1L), any(OrderItem.class))).thenReturn(orderItem);

        // Perform PUT request and verify the result
        mockMvc.perform(put("/order-items/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderId\":1,\"productId\":1,\"quantity\":10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(10));
    }

    @Test
    void testDeleteOrderItem() throws Exception {
        // Perform DELETE request and verify the result
        mockMvc.perform(delete("/order-items/1"))
                .andExpect(status().isOk());

        // Verify that the delete method was called
        verify(orderItemService).deleteOrderItem(1L);
    }
}
