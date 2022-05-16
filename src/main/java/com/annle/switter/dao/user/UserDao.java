package com.annle.switter.dao.user;

import com.annle.switter.model.User;

public interface UserDao {

    boolean add(User user);

    boolean delete(User user);

    boolean findByCredentials(String username, String password);

    User getByCredentials(String username, String password);
}
