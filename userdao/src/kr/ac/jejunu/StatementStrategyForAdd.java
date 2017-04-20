package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-20.
 */
public class StatementStrategyForAdd implements StatementStrategy {
    @Override
    public PreparedStatement getPreparedStatement(Object object, Connection connection) throws SQLException {
        User user = (User) object;
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo VALUES (?, ?, ?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        return preparedStatement;
    }
}
