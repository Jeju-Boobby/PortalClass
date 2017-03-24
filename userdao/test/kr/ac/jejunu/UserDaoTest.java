package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.SQLException;

/**
 * Created by Boobby on 17-3-15.
 */
public class UserDaoTest {
    UserDao userDao;

    @Before
    public void setup() {
//        daoFactory = new DaoFactory();
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = context.getBean("userDao", UserDao.class);
    }
    @Test
    public void get() throws Exception {
        Long id = 1L;
        String name = "은형";
        String password = "1111";

        User user = userDao.get(id);
        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "은형";
        user.setName(name);

        String password = "1111";
        user.setPassword(password);

        Long id = userDao.add(user);
        User resultUser = userDao.get(id);

        assertThat(id,  is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }
}