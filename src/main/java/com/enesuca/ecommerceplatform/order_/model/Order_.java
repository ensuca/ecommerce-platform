package com.enesuca.ecommerceplatform.order_.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Order_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private Integer quantity;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDate;
    private String status;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<OrderItem> orderItems = new ArrayList<>();

    // Default constructor
    public Order_() {
    }

    // Parameterized constructor
    public Order_(Long userId, Long productId, Integer quantity, LocalDateTime orderDate, String status) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
    }



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Integer getQuantity() {
        return quantity;
    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }



    public <E> void setOrderItems(ArrayList<E> es) {
    }
}
