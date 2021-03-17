package com.denisanfossi.myuserlist.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.denisanfossi.myuserlist.databinding.ActivityUserProfileBinding;
import com.denisanfossi.myuserlist.model.User;

public class UserProfileActivity extends AppCompatActivity {

    private ActivityUserProfileBinding mBinding;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mUser = (User) getIntent().getSerializableExtra("user");

        configureUI();
    }

    private void configureUI() {
        mBinding.nameTextview.setText(mUser.getName());
        Glide.with(this).load(mUser.getAvatarUrl()).into(mBinding.avatarProfileImageview);
    }

}