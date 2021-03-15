package com.denisanfossi.myuserlist.data.source;

import androidx.annotation.VisibleForTesting;

import com.denisanfossi.myuserlist.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeUsersGenerator {
    @VisibleForTesting
    public static final List<User> FAKE_USERS = Arrays.asList(
            new User(0L, "Paul", "https://avatars.dicebear.com/api/bottts/Paul.png"),
            new User(1L, "Marc", "https://avatars.dicebear.com/api/bottts/Marc.png"),
            new User(2L, "Lena", "https://avatars.dicebear.com/api/bottts/Lena.png"),
            new User(3L, "John", "https://avatars.dicebear.com/api/bottts/John.png"),
            new User(4L, "Laura", "https://avatars.dicebear.com/api/bottts/Laura.png"),
            new User(5L, "Théo", "https://avatars.dicebear.com/api/bottts/Theo.png"),
            new User(6L, "Charles", "https://avatars.dicebear.com/api/bottts/Charles.png"),
            new User(7L, "Marie", "https://avatars.dicebear.com/api/bottts/Marie.png"),
            new User(8L, "Chloé", "https://avatars.dicebear.com/api/bottts/Chloe.png"),
            new User(9L, "George", "https://avatars.dicebear.com/api/bottts/George.png"),
            new User(10L, "Solange", "https://avatars.dicebear.com/api/bottts/Solange.png"),
            new User(11L, "Pedro", "https://avatars.dicebear.com/api/bottts/Pedro.png"),
            new User(12L, "Jeanne", "https://avatars.dicebear.com/api/bottts/Jeanne.png"),
            new User(13L, "Martin", "https://avatars.dicebear.com/api/bottts/Martin.png"),
            new User(14L, "Lucas", "https://avatars.dicebear.com/api/bottts/Lucas.png")
    );

    public static List<User> generateUsers() {
        return new ArrayList<>(FAKE_USERS);
    }
}
