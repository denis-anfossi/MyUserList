package com.denisanfossi.myuserlist;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.data.source.FakeUsersGenerator;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserRepositoryTest {
    private UsersRepository mUsersRepository;

    @Before
    public void setup() {
        Injection.startInjection();
        mUsersRepository = Injection.getUsersRepository();
    }

    @Test
    public void getUsersWithSuccess() {
        List<User> users = mUsersRepository.getUsers();
        List<User> expectedUsers = FakeUsersGenerator.FAKE_USERS;

        assertThat(users, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedUsers.toArray()));
    }

    // TODO add test createUser

    // TODO add test deleteUser
}
