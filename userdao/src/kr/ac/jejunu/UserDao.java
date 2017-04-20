package kr.ac.jejunu;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-20.
 */
public class UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User get(Long id) throws SQLException {
        String sql = "select * from userinfo where id = ?";
        Object[] params = {id};

        User user1 = null;
        try {
            user1 = jdbcTemplate.queryForObject(sql, params, (resultSet, i) -> {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));

                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        return user1;
    }

    public void add(User user) throws SQLException {
        String sql = "insert into userinfo VALUES (?, ?, ?)";
        Object[] params = {user.getId(), user.getName(), user.getPassword()};

        jdbcTemplate.update(sql, params);
    }

    public void delete(Long id) throws SQLException {
        String sql = "delete from userinfo WHERE id = ?";
        Object[] params = {id};

        jdbcTemplate.update(sql, params);
    }
}
