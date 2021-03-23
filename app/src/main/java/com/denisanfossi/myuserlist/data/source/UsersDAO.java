package com.denisanfossi.myuserlist.data.source;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.denisanfossi.myuserlist.model.User;

import java.util.List;

@Dao
public abstract class UsersDAO implements UsersDataSource {

    @Override
    @Query("SELECT * FROM users")
    public abstract LiveData<List<User>> getUsers();

    @Override
    @Insert
    public abstract void createUser(User user);

    @Override
    @Delete
    public abstract void deleteUser(User user);
}
