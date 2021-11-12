package webshop.product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    public static final String STATUS = "status";
    public static final String PRICE = "price";
    public static final String ADDRESS = "address";
    public static final String MANUFACTURER = "manufacturer";

    public ProductDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> listAllProducts() {
        return jdbcTemplate.query("select id, code, name, address, manufacturer, price, status from products order by name, manufacturer", new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString(ADDRESS),
                        resultSet.getString(MANUFACTURER),
                        resultSet.getInt(PRICE),
                        ProductStatus.valueOf(resultSet.getString(STATUS)));
            }
        });
    }


}
