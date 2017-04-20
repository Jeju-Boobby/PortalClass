package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-20.
 */
public class StatementStrategyForUpdate implements StatementStrategy {
    private Long id;

    public StatementStrategyForUpdate(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from userinfo WHERE id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
