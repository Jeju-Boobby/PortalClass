package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-14.
 */
public interface ConnectioinMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException, SQLException;
}
