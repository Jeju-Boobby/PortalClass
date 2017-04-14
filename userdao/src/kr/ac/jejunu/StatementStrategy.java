package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-3-31.
 */
public interface StatementStrategy {
    PreparedStatement makeStatement(Connection connection) throws SQLException;
}
