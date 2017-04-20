package kr.ac.jejunu;

/**
 * Created by Boobby on 17-4-20.
 */
public class DaoFactory {

    public UserDao getUserDao() {
        UserDao userDao  = new UserDao(getConnectionMaker());
        return userDao;
    }

    public ConnectionMaker getConnectionMaker() {
        ConnectionMaker connectionMaker = new NConnectionMaker();
        return connectionMaker;
    }
}
