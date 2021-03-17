package com.denisanfossi.myuserlist.data.source;

import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public class FakeUsersDataSource implements UsersDataSource {
    private final List<User> mUsers = FakeUsersGenerator.generateUsers();

    @Override
    public List<User> getUsers() {
        return mUsers;
    }

    @Override
    public void createUser(User user) {
        mUsers.add(user);
    }

    @Override
    public void deleteUser(User user) {
        mUsers.remove(user);
    }
}
