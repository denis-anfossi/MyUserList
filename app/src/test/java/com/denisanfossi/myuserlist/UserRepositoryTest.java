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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    @Test
    public void createUserWithSuccess() {
        User user = new User(15L, "Fabrice", "https://avatars.dicebear.com/api/bottts/Fabrice.png");
        assertFalse(mUsersRepository.getUsers().contains(user));
        mUsersRepository.createUser(user);
        assertTrue(mUsersRepository.getUsers().contains(user));
    }

    // TODO add test deleteUser
    @Test
    public void deleteUserWithSuccess() {
        User user = mUsersRepository.getUsers().get(0);
        assertTrue(mUsersRepository.getUsers().contains(user));
        mUsersRepository.deleteUser(user);
        assertFalse(mUsersRepository.getUsers().contains(user));
    }
}
