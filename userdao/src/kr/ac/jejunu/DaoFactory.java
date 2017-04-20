package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by Boobby on 17-4-20.
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao  = new UserDao();
        userDao.setJdbcTemplate(jdbcTemplate());
        return userDao;
    }

    @Bean
    private JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());

        return jdbcTemplate;
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.mariadb.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/portal?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("qkqh1125");
        return dataSource;
    }
}
