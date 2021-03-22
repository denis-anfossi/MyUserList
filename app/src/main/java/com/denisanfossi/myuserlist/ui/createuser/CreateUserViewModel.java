package com.denisanfossi.myuserlist.ui.createuser;

import androidx.lifecycle.ViewModel;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CreateUserViewModel extends ViewModel {
    private final UsersRepository mUsersRepository = Injection.getUsersRepository();
    private final Executor mExecutor = Executors.newSingleThreadExecutor();

    public void createUser(User user) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mUsersRepository.createUser(user);
            }
        });
    }
}
