package com.denisanfossi.myuserlist.data.source;

import androidx.lifecycle.LiveData;

import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public interface UsersDataSource {

    LiveData<List<User>> getUsers();

    void createUser(User user);

    void deleteUser(User user);
}
