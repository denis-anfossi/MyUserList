package com.denisanfossi.myuserlist;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.data.source.FakeUsersGenerator;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserRepositoryTest {
    private UsersRepository mUsersRepository;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        Injection.startInjection();
        mUsersRepository = Injection.getUsersRepository();
    }

    @Test
    public void getUsersWithSuccess() throws InterruptedException {
        List<User> users = LiveDataTestUtil.getValue(mUsersRepository.getUsers());
        List<User> expectedUsers = FakeUsersGenerator.FAKE_USERS;

        assertThat(users, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedUsers.toArray()));
    }

    @Test
    public void createUserWithSuccess() throws InterruptedException {
        User user = new User(15L, "Fabrice", "https://avatars.dicebear.com/api/bottts/Fabrice.png");
        assertFalse(LiveDataTestUtil.getValue(mUsersRepository.getUsers()).contains(user));
        mUsersRepository.createUser(user);
        assertTrue(LiveDataTestUtil.getValue(mUsersRepository.getUsers()).contains(user));
    }

    @Test
    public void deleteUserWithSuccess() throws InterruptedException {
        User user = LiveDataTestUtil.getValue(mUsersRepository.getUsers()).get(0);
        assertTrue(LiveDataTestUtil.getValue(mUsersRepository.getUsers()).contains(user));
        mUsersRepository.deleteUser(user);
        assertFalse(LiveDataTestUtil.getValue(mUsersRepository.getUsers()).contains(user));
    }
}
