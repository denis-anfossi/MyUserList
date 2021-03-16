package com.denisanfossi.myuserlist;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.data.source.FakeUsersGenerator;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
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
    @Test
    public void createWithSuccess() {
        User userToCreate = new User(15L, "Denis", "https://avatars.dicebear.com/api/bottts/Denis.png");

        Assert.assertFalse(mUsersRepository.getUsers().contains(userToCreate));
        mUsersRepository.createUser(userToCreate);
        Assert.assertTrue(mUsersRepository.getUsers().contains(userToCreate));
    }

    // TODO add test deleteUser
    @Test
    public void deleteWithSuccess() {
        User userToDelete = mUsersRepository.getUsers().get(0);
        Assert.assertTrue(mUsersRepository.getUsers().contains(userToDelete));
        mUsersRepository.deleteUser(userToDelete);
        Assert.assertFalse(mUsersRepository.getUsers().contains(userToDelete));
    }
}
