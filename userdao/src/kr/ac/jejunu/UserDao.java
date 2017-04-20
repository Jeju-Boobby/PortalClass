package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Boobby on 17-4-20.
 */
public class UserDao {
    JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };

        return jdbcContext.jdbcContextWithStatementStrategyForGet(statementStrategy);
    }

    public void add(User user) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo VALUES (?, ?, ?)");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());

            return preparedStatement;
        };

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("delete from userinfo WHERE id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }


}
