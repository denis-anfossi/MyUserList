package com.denisanfossi.myuserlist.data.source;

import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public interface UsersDataSource {

    List<User> getUsers();

    // TODO add method createUser
    void createUser(User user);

    // TODO add method deleteUser
    void deleteUser(User user);
}
