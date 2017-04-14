package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by Boobby on 17-4-14.
 */
public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal?characterEncoding=utf-8", "root", "qkqh1125");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");

        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword((resultSet.getString("password")));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal?characterEncoding=utf-8", "root", "qkqh1125");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo VALUES (?, ?, ?)");

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
