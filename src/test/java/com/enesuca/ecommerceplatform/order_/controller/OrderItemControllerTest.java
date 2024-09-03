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
        mockMvc.perform(get("/api/order-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(orderItem.getId()));
    }

    @Test
    void testCreateOrderItem() throws Exception {
        // Mock service to return the created order item
        when(orderItemService.createOrderItem(any(OrderItem.class))).thenReturn(orderItem);

        // Perform POST request and verify the result
        mockMvc.perform(post("/api/order-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderId\":1,\"productId\":1,\"quantity\":5}"))
                .andExpect(status().isCreated())  // 201 yerine 200 kullanmışsınız, fakat doğru olanı 201'dir
                .andExpect(jsonPath("$.id").value(orderItem.getId()));
    }

    @Test
    void testGetOrderItemById() throws Exception {
        // Mock service to return an order item by ID
        when(orderItemService.getOrderItemById(1L)).thenReturn(Optional.of(orderItem));

        // Perform GET request and verify the result
        mockMvc.perform(get("/api/order-items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderItem.getId()));
    }

    @Test
    void testUpdateOrderItem() throws Exception {
        // Mock service to return the updated order item
        orderItem.setQuantity(10);
        when(orderItemService.updateOrderItem(eq(1L), any(OrderItem.class))).thenReturn(orderItem);

        // Perform PUT request and verify the result
        mockMvc.perform(put("/api/order-items/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderId\":1,\"productId\":1,\"quantity\":10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(10));

        // Mock service to return null when order item is not found
        when(orderItemService.updateOrderItem(eq(2L), any(OrderItem.class))).thenReturn(null);

        // Perform PUT request for a non-existent order item and verify the result
        mockMvc.perform(put("/api/order-items/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderId\":2,\"productId\":2,\"quantity\":20}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteOrderItem() throws Exception {
        mockMvc.perform(delete("/api/order-items/1"))
                .andExpect(status().isNoContent()); // 204 No Content durum kodu beklenir

        verify(orderItemService).deleteOrderItem(1L);
    }
}
