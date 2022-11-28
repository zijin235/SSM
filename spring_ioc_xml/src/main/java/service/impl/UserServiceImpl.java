package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void SaveUser() {
        userDao.SaveUser();
    }
}
