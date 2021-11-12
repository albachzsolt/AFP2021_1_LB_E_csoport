package webshop.product;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    public ProductDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


}
