package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-3-31.
 */
public class DeleteUserStratementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        Long id = (Long) object;
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userinfo WHERE id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
