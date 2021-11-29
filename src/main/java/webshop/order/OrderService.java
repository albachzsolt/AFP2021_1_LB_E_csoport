package webshop.order;

import org.springframework.stereotype.Service;
import webshop.basket.BasketDao;
import webshop.user.UserDao;

@Service
public class OrderService {
    private OrderDao orderDao;
    private UserDao userDao;
    protected BasketDao basketDao;

    public OrderService(OrderDao orderDao, UserDao userDao, BasketDao basketDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.basketDao = basketDao;
    }
}
