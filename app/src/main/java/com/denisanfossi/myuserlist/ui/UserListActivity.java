package com.denisanfossi.myuserlist.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denisanfossi.myuserlist.databinding.ActivityUserListBinding;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private final List<User> mUsers = new ArrayList<>();
    private ActivityUserListBinding mBinding;
    private UserListAdapter mUserListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        configureRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshUserList();
    }

    private void refreshUserList() {
        mUsers.clear();
        mUsers.addAll(Injection.getUsersRepository().getUsers());
        mUserListAdapter.notifyDataSetChanged();
    }

    private void configureRecyclerView() {
        mUserListAdapter = new UserListAdapter(mUsers);
        mBinding.activityUserListRecyclerView.setAdapter(mUserListAdapter);
    }
}