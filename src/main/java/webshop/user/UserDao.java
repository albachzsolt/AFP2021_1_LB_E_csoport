package webshop.user;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDao {

    private JdbcTemplate jdbcTemplate;
    private static final String USERNAME = "username";

    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
