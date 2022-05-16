package com.annle.switter.service.user;

import com.annle.switter.dao.user.UserDaoImpl;
import com.annle.switter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public boolean isRegistered(String username, String password) {
        return userDao.findByCredentials(username, password);
    }

    @Override
    public User getUserByCredentials(String username, String password) {
        return userDao.getByCredentials(username, password);
    }
}
