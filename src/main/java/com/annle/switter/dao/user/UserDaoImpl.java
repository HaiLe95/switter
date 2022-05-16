package com.annle.switter.dao.user;

import com.annle.switter.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private List<User> database = new ArrayList<>();

    @Override
    public boolean add(User user) {
        boolean exist = database.stream().anyMatch(note -> note.equals(user));
        if(!exist) database.add(user);
        return exist;
    }

    @Override
    public boolean findByCredentials(String username, String password) {
        return database
                .stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    @Override
    public boolean delete(User user) {
        return database.remove(user);
    }

    @Override
    public User getByCredentials(String username, String password) {
        return database
                .stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findAny()
                .get();
    }
}
