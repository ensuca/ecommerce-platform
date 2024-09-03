package com.enesuca.ecommerceplatform.order_.controller;

import com.enesuca.ecommerceplatform.order_.model.Order_;
import com.enesuca.ecommerceplatform.order_.model.OrderItem;
import com.enesuca.ecommerceplatform.order_.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Order_ order;
    private OrderItem orderItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);

        mockMvc = MockMvcBuilders.standaloneSetup(orderController)
                .setMessageConverters(converter)
                .build();

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
        orderItem.setQuantity(10);
    }

    @Test
    void testGetAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(Arrays.asList(order));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(order.getId()));
    }

    @Test
    public void testCreateOrder() throws Exception {
        Order_ order = new Order_();
        // initialize with necessary data
        List<OrderItem> orderItems = Arrays.asList(orderItem);

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setOrder(order);
        createOrderRequest.setOrderItems(orderItems);

        when(orderService.createOrder(any(Order_.class), any(List.class))).thenReturn(order);

        String jsonRequest = objectMapper.writeValueAsString(createOrderRequest);
        System.out.println("JSON Request: " + jsonRequest);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetOrderById() throws Exception {
        when(orderService.getOrderById(1L)).thenReturn(Optional.of(order));

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()));
    }

    @Test
    void testGetOrderByIdNotFound() throws Exception {
        when(orderService.getOrderById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateOrder() throws Exception {
        Order_ updatedOrder = new Order_();
        updatedOrder.setUserId(1L);
        updatedOrder.setProductId(1L);
        updatedOrder.setQuantity(15);  // Set the quantity field
        updatedOrder.setOrderDate(LocalDateTime.now());
        updatedOrder.setStatus("SHIPPED");

        when(orderService.updateOrder(eq(1L), any(Order_.class))).thenReturn(updatedOrder);

        mockMvc.perform(put("/api/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedOrder)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(15));  // Assert the quantity
    }

    @Test
    void testDeleteOrder() throws Exception {
        doNothing().when(orderService).deleteOrder(1L);

        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNoContent());

        verify(orderService).deleteOrder(1L);
    }

    @Test
    void testRootEndpoint() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/orders/root"))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }
}