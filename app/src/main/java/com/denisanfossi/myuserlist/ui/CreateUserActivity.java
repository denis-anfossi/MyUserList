package com.denisanfossi.myuserlist.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denisanfossi.myuserlist.databinding.ActivityCreateUserBinding;

public class CreateUserActivity extends AppCompatActivity {

    private ActivityCreateUserBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCreateUserBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

}