package webshop.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import webshop.product.ProductDao;
import webshop.user.UserDao;

import javax.sql.DataSource;

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
}
