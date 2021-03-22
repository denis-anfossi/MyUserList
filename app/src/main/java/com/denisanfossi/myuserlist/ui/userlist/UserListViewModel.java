package com.denisanfossi.myuserlist.ui.userlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserListViewModel extends ViewModel {
    private final UsersRepository mUsersRepository = Injection.getUsersRepository();
    private final Executor mExecutor = Executors.newSingleThreadExecutor();

    public LiveData<List<User>> getUsers() {
        return mUsersRepository.getUsers();
    }

    public void deleteUser(User user) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mUsersRepository.deleteUser(user);
            }
        });
    }
}
