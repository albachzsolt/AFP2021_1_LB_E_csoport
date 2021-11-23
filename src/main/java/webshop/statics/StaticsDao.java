package webshop.statics;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class StaticsDao {
    private JdbcTemplate jdbcTemplate;

    public StaticsDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
