package webshop.order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderDao {
    private JdbcTemplate jdbcTemplate;

    public static final String USER_ID = "user_id";
    public static final String STATUS = "status";
    public static final String SHIPPING_ADDRESS = "shipping_address";
    public static final String ORDER_ID = "order_id";

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insertIntoOrdersFromBasketsByUserId(long userId, String shippingAddress) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into orders set user_id = ?, " +
                        "order_time = ?, status = ?, shipping_address = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, userId);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setString(3, OrderStatus.ACTIVE.name());
                ps.setString(4, shippingAddress);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public void insertIntoOrderedItemsFromBasketItemsByOrderId(long orderId, long productId, int quantity,
                                                               long totalPrice) {
        jdbcTemplate.update("insert into ordered_items set order_id = ?, product_id = ?, quantity = ?, " +
                "order_price = ?", orderId, productId, quantity, totalPrice);
    }
}
