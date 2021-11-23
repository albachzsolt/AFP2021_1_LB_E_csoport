package webshop.order;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private long userId;
    private LocalDateTime orderTime;
    private OrderStatus orderStatus;
    private long totalOrderPrice;
    private String shippingAddress;
    private List<OrderItem> orderItems;

    public Order(long id, long userId, LocalDateTime orderTime, OrderStatus orderStatus, long totalOrderPrice,
                 String shippingAddress) {
        this.id = id;
        this.userId = userId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.totalOrderPrice = totalOrderPrice;
        this.shippingAddress = shippingAddress;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public long getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalOrderPrice(long totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
