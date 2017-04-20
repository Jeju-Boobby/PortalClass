package kr.ac.jejunu;

import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-20.
 */
public class UserDao {
    JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Long id) throws SQLException {
        String sql = "select * from userinfo where id = ?";
        Object[] params = {id};

        return jdbcContext.get(sql, params);
    }

    public void add(User user) throws SQLException {
        String sql = "insert into userinfo VALUES (?, ?, ?)";
        Object[] params = {user.getId(), user.getName(), user.getPassword()};

        jdbcContext.update(sql, params);
    }

    public void delete(Long id) throws SQLException {
        String sql = "delete from userinfo WHERE id = ?";
        Object[] params = {id};

        jdbcContext.update(sql, params);
    }
}
