package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Boobby on 17-4-20.
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao  = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        NConnectionMaker connectionMaker = new NConnectionMaker();
        connectionMaker.setClassName("org.mariadb.jdbc.Driver");
        connectionMaker.setUrl("jdbc:mysql://localhost:3306/portal?characterEncoding=utf-8");
        connectionMaker.setUser("root");
        connectionMaker.setPassword("qkqh1125");
        return connectionMaker;
    }
}
