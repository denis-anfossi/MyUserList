package com.denisanfossi.myuserlist.data.repository;

import androidx.lifecycle.LiveData;

import com.denisanfossi.myuserlist.data.source.UsersDataSource;
import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public class UsersRepository {
    private final UsersDataSource mUsersDataSource;

    public UsersRepository(UsersDataSource usersDataSource) {
        mUsersDataSource = usersDataSource;
    }

    public LiveData<List<User>> getUsers() {
        return mUsersDataSource.getUsers();
    }

    public void createUser(User user) {
        mUsersDataSource.createUser(user);
    }

    public void deleteUser(User user) {
        mUsersDataSource.deleteUser(user);
    }
}
