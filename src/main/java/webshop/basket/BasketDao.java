package webshop.basket;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

    public long createBasketForUserIdAndReturnBasketId(long userId) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
                                @Override
                                public PreparedStatement createPreparedStatement(Connection connection)
                                        throws SQLException {
                                    PreparedStatement ps =
                                            connection.prepareStatement("insert into baskets" +
                                                            "(user_id) values (?)",
                                                    Statement.RETURN_GENERATED_KEYS);
                                    ps.setLong(1, userId);
                                    return ps;
                                }
                            }, keyHolder
        );

        return keyHolder.getKey().longValue();
    }
}
