package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Boobby on 17-4-14.
 */
public class DConnectioinMaker implements ConnectioinMaker {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/portal?characterEncoding=utf-8", "root", "qkqh1125");
    }
}
