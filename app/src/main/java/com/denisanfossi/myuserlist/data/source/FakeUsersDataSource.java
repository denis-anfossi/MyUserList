package com.denisanfossi.myuserlist.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public class FakeUsersDataSource implements UsersDataSource {
    private final List<User> mUsers = FakeUsersGenerator.generateUsers();
    private final MutableLiveData<List<User>> mUsersLiveData = new MutableLiveData<>(mUsers);

    @Override
    public LiveData<List<User>> getUsers() {
        return mUsersLiveData;
    }

    @Override
    public void createUser(User user) {
        mUsers.add(user);
        mUsersLiveData.postValue(mUsers);
    }

    @Override
    public void deleteUser(User user) {
        mUsers.remove(user);
        mUsersLiveData.postValue(mUsers);
    }
}
