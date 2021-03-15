package com.denisanfossi.myuserlist.data.repository;

import com.denisanfossi.myuserlist.data.source.UsersDataSource;
import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public class UsersRepository {
    private final UsersDataSource mUsersDataSource;

    public UsersRepository(UsersDataSource usersDataSource) {
        mUsersDataSource = usersDataSource;
    }

    public List<User> getUsers() {
        return mUsersDataSource.getUsers();
    }

    // TODO add method createUser

    // TODO add method deleteUser
}
