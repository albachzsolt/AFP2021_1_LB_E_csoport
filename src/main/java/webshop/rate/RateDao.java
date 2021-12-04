package webshop.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import webshop.product.ProductDao;
import webshop.user.UserDao;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class RateDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    public RateDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long addNewRateAndGetId(Rate rate) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Date date = Date.valueOf(rate.getDate());
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into ratings (user_id, product_id, " +
                        "stars, message, rating_time) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, rate.getUser().getId());
                ps.setLong(2, rate.getProduct().getId());
                ps.setInt(3, rate.getStars());
                ps.setString(4, rate.getMessage());
                ps.setDate(5, date);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
