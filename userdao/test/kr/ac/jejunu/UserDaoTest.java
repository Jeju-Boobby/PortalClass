package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Boobby on 17-4-14.
 */
public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        Long id = 1L;
        User user = userDao.get(id);

        String name = "부은형";
        String password = "111111";

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        Long id = Long.valueOf(new Random().nextInt());
        String name = "Boooo";
        String password = "123123";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.add(user);

        User addedUser = userDao.get(id);

        assertThat(addedUser.getId(), is(id));
        assertThat(addedUser.getName(), is(name));
        assertThat(addedUser.getPassword(), is(password));
    }

}