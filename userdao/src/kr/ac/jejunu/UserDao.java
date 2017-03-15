package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by Boobby on 17-3-15.
 */
public class UserDao {
    public User get(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {

        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo(name, password) VALUES (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("SELECT last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Long id = resultSet.getLong(1);

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return id;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "qkqh1125");
    }
}
