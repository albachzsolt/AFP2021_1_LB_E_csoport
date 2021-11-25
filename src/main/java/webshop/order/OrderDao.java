package webshop.order;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
    private JdbcTemplate jdbcTemplate;

    public static final String USER_ID = "user_id";
    public static final String STATUS = "status";
    public static final String SHIPPING_ADDRESS = "shipping_address";
    public static final String ORDER_ID = "order_id";

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
