package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Boobby on 17-3-24.
 */
@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());

        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        JejuConnectionMaker connectionMaker = new JejuConnectionMaker();
        connectionMaker.setPassword("qkqh1125");
        connectionMaker.setClassName("org.mariadb.jdbc.Driver");
        connectionMaker.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8");
        connectionMaker.setUser("root");
        return connectionMaker;
    }
}
