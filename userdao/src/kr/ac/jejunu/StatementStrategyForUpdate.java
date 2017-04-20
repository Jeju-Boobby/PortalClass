package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-20.
 */
public class StatementStrategyForUpdate implements StatementStrategy {
    @Override
    public PreparedStatement getPreparedStatement(Object object, Connection connection) throws SQLException {
        Long id = (Long) object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from userinfo WHERE id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
