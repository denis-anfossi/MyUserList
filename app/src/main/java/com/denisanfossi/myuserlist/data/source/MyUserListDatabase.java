package com.denisanfossi.myuserlist.data.source;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.denisanfossi.myuserlist.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class MyUserListDatabase extends RoomDatabase {

    private static MyUserListDatabase INSTANCE;

    public static MyUserListDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyUserListDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyUserListDatabase.class, "my_user_list_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UsersDAO usersDAO();
}
