package com.denisanfossi.myuserlist.di;

import android.content.Context;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.data.source.FakeUsersDataSource;
import com.denisanfossi.myuserlist.data.source.UserDatabase;
import com.denisanfossi.myuserlist.data.source.UsersDAO;

public class Injection {
    private static UsersRepository sUsersRepository;

    public static void startInjectionWithContext(Context applicationContext) {
        UsersDAO usersDAO = UserDatabase.getDatabase(applicationContext).usersDAO();
        sUsersRepository = new UsersRepository(usersDAO);
    }

    public static void startInjection() {
        sUsersRepository = new UsersRepository(new FakeUsersDataSource());
    }

    public static UsersRepository getUsersRepository() {
        return sUsersRepository;
    }

}
