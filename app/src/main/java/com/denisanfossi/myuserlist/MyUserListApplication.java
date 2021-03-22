package com.denisanfossi.myuserlist;

import android.app.Application;

import com.denisanfossi.myuserlist.di.Injection;

public class MyUserListApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Injection.startInjectionWithContext(getApplicationContext());
    }
}
