package com.enesuca.ecommerceplatform.order_.controller;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private Order_ order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        // Initialize sample order object for testing
        order = new Order_();
        order.setId(1L);
        order.setUserId(1L);
        order.setProductId(1L);
        order.setQuantity(10);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
    }

    @Test
    void testGetAllOrders() throws Exception {
        // Mock service to return a list of orders
        when(orderService.getAllOrders()).thenReturn(Arrays.asList(order));

        // Perform GET request and verify the result
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(order.getId()))
                .andExpect(jsonPath("$[0].status").value(order.getStatus()));
    }

    @Test
    void testCreateOrder() throws Exception {
        // Mock service to return the created order
        when(orderService.createOrder(any(Order_.class), anyList())).thenReturn(order);

        // Perform POST request and verify the result
        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1,\"productId\":1,\"quantity\":10,\"orderDate\":\"2024-08-30T10:00:00\",\"status\":\"PENDING\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()));
    }

    @Test
    void testGetOrderById() throws Exception {
        // Mock service to return an order by ID
        when(orderService.getOrderById(1L)).thenReturn(Optional.of(order));

        // Perform GET request and verify the result
        mockMvc.perform(get("/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()));
    }

    @Test
    void testUpdateOrder() throws Exception {
        // Mock service to return the updated order
        when(orderService.updateOrder(eq(1L), any(Order_.class), anyList())).thenReturn(order);

        // Perform PUT request and verify the result
        mockMvc.perform(put("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1,\"productId\":1,\"quantity\":15,\"orderDate\":\"2024-08-30T10:00:00\",\"status\":\"SHIPPED\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(15));
    }

    @Test
    void testDeleteOrder() throws Exception {
        // Perform DELETE request and verify the result
        mockMvc.perform(delete("/orders/1"))
                .andExpect(status().isOk());

        // Verify that the delete method was called
        verify(orderService).deleteOrder(1L);
    }
}
