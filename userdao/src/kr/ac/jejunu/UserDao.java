package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by Boobby on 17-4-14.
 */
public class UserDao {
    ConnectioinMaker connectioinMaker;

    public UserDao(ConnectioinMaker connectioinMaker) {
        this.connectioinMaker = connectioinMaker;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = connectioinMaker.getConnection();

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
        Connection connection = connectioinMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo VALUES (?, ?, ?)");

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

//    public Connection getConnection() throws ClassNotFoundException, SQLException;
//    {
//        Class.forName("org.mariadb.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/portal?characterEncoding=utf-8", "root", "qkqh1125");
//    }
}
