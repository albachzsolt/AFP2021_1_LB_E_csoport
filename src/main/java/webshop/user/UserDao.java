package webshop.user;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;
    private static final String USERNAME = "username";

    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long createUserAndReturnUserId(User user) throws DuplicateKeyException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into users " +
                        "(first_name, last_name, username, " + "password, enabled, role) values " + "(?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getUsername());
                ps.setString(4, user.getPassword());
                ps.setInt(5, user.getEnabled());
                ps.setString(6, user.getUserRole().name());
                return ps;
            }
            }, keyHolder
        );
        return keyHolder.getKey().longValue();
    }

    public List<String> getAllUsernames() {
        return jdbcTemplate.query("select username from users order by username",
                (resultSet, i) -> resultSet.getString(USERNAME));
    }

    public List<User> listAllUsers() {
        return jdbcTemplate.query("select id, first_name, last_name, username, password, role, enabled from users" +
                "order by username", (rs, rowNum) -> new User(rs.getInt("id"),
                rs.getString("first_name"), rs.getString("last_name"), rs.getString(USERNAME),
                rs.getString("password"), rs.getInt("enabled"),
                UserRole.valueOf(rs.getString("role"))));
    }
}
