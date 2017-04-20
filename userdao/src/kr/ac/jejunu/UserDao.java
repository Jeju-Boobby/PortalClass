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
        StatementStrategy statementStrategy = new StatementStrategyForGet(id);

        return jdbcContext.jdbcContextWithStatementStrategyForGet(statementStrategy);
    }

    public void add(User user) throws SQLException {
        StatementStrategy statementStrategy = new StatementStrategyForAdd(user);

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new StatementStrategyForUpdate(id);

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }


}
