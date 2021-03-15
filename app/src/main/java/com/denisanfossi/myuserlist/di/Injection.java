package com.denisanfossi.myuserlist.di;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.data.source.FakeUsersDataSource;

public class Injection {
    private static UsersRepository sUsersRepository;

    public static void startInjection() {
        sUsersRepository = new UsersRepository(new FakeUsersDataSource());
    }

    public static UsersRepository getUsersRepository() {
        return sUsersRepository;
    }

}
