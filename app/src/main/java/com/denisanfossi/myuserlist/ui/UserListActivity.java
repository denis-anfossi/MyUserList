package com.denisanfossi.myuserlist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denisanfossi.myuserlist.databinding.ActivityUserListBinding;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListAdapter.Listener {

    private final List<User> mUsers = new ArrayList<>();
    private ActivityUserListBinding mBinding;
    private UserListAdapter mUserListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        configureRecyclerView();
        configureFAB();
    }

    private void configureRecyclerView() {
        mUserListAdapter = new UserListAdapter(mUsers, this);
        mBinding.activityUserListRecyclerView.setAdapter(mUserListAdapter);
    }

    private void configureFAB() {
        mBinding.activityUserListFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateUserActivity.class);
                startActivity(intent);
            }
        });
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

    @Override
    public void onClickDeleteButton(int position) {
        Injection.getUsersRepository().deleteUser(mUsers.get(position));
        refreshUserList();
    }
}