package webshop.order;

import org.springframework.stereotype.Service;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.basket.BasketDao;
import webshop.basket.BasketItem;
import webshop.user.User;
import webshop.user.UserDao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public CustomResponseStatus placeOrder(String loggedInUsername, String shippingAddress) {
        User user = userDao.getUserByUsername(loggedInUsername);
        long userId = user.getId();
        long basketId = basketDao.getBasketIdByUserId(userId);
        List<BasketItem> products = basketDao.getBasketItemsInBasketByBasketId(basketId);
        if (products.isEmpty()) {
            return new CustomResponseStatus(Response.FAILED, "Your cart is empty.");
        }
        long orderId = orderDao.insertIntoOrdersFromBasketsByUserId(userId, shippingAddress);
        for (BasketItem basketItem : products) {
            orderDao.insertIntoOrderedItemsFromBasketItemsByOrderId(orderId, basketItem.getProduct().getId(),
                    basketItem.getPieces(), basketItem.getProduct().getPrice() * basketItem.getPieces());
        }
        basketDao.clearBasketByBasketId(basketId);
        return new CustomResponseStatus(Response.SUCCESS, "Your order was placed, thank you for your purchase.");
    }

    public List<Order> listOrdersByOrderId(String loggedInUsername) {
        User user = userDao.getUserByUsername(loggedInUsername);

        long userId = user.getId();

        List<Order> orders = orderDao.listOrdersByUserId(userId);

        for (Order order : orders) {
            order.setOrderItems(orderDao.listOrderItemsByOrderId(order.getId()));
        }
        return orders;
    }

    public List<OrderData> listAllOrderData() {
        return orderDao.listAllOrderData();
    }

    public List<OrderItem> listOrderItemsByOrderId(long orderId) {
        return orderDao.listOrderItemsByOrderId(orderId);
    }

    public int logicalDeleteOrderByOrderId(long orderId) {
        return orderDao.logicalDeleteOrderByOrderId(orderId);
    }

    public int deleteItemFromOrderByProductAddress(long orderId, String productAddress) {
        return orderDao.deleteItemFromOrderByProductAddress(orderId, productAddress);
    }

    public List<OrderData> listFilteredOrderData(String filter) {
        return orderDao.listFilteredOrderData(filter);
    }

    public OrderStatus getOrderStatusByOrderId(long orderId) {
        return orderDao.getOrderStatusByOrderId(orderId);
    }

    public boolean isOrderDeleted(long orderId) {
        return getOrderStatusByOrderId(orderId) == OrderStatus.DELETED;
    }

    public boolean isOrderDelivered(long orderId) {
        return getOrderStatusByOrderId(orderId) == OrderStatus.DELIVERED;
    }

    public int updateOrderStatus(long orderId, String newOrderStatus) {
        return orderDao.updateOrderStatus(orderId, newOrderStatus);
    }

    public List<Order> getOrderListWithFormerShippingAddressesOnly(String loggedInUsername) {
        User user = userDao.getUserByUsername(loggedInUsername);
        long userId = user.getId();
        return orderDao.getOrderListByUserIdWithFormerShippingAddressesOnly(userId);
    }

    public boolean isShippingAddressAlreadyStored(String loggedInUsername, String shippingAddress) {
        Stream<Order> s = getOrderListWithFormerShippingAddressesOnly(loggedInUsername).stream();
        List<String> formerShippingAddresses = s.map(Order::getShippingAddress).map(String::toLowerCase).map(e -> e.replaceAll("[\\s,.=!%?@&$???#(){}<>\\[\\]]","")).collect(Collectors.toList());
        return formerShippingAddresses.contains(shippingAddress.toLowerCase().replaceAll("[\\s,.=!%?@&$???#(){}<>\\[\\]]", ""));
    }
}
