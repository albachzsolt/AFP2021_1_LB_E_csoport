package webshop.order;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private long userId;
    private LocalDateTime orderTime;
    private OrderStatus orderStatus;
    private long totalOrderPrice;
    private String shippingAddress;
}
