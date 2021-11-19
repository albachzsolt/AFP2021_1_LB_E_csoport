package webshop.basket;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BasketDao {

    private JdbcTemplate jdbcTemplate;

    private static final String QUANTITY = "quantity";
    private static final String BASKET_ID = "basket_id";
    private static final String PRODUCT_ID = "product_id";

    public BasketDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Long> getAllBasketOwnerIds() {
        return jdbcTemplate.query("select user_id from baskets",
                (resultSet, i) -> resultSet.getLong("user_id"));
    }
}
