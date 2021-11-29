package webshop.order;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private OrderService orderService;
    private OrderValidator orderValidator = new OrderValidator();

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
