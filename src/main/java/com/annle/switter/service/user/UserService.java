package com.annle.switter.service.user;

import com.annle.switter.model.User;

public interface UserService {

    boolean add(User user);

    boolean delete(User user);

    boolean isRegistered(String username, String password);

    User getUserByCredentials(String username, String password);

}
