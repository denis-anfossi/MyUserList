package com.denisanfossi.myuserlist.ui.userlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.denisanfossi.myuserlist.databinding.ActivityUserListBinding;
import com.denisanfossi.myuserlist.model.User;
import com.denisanfossi.myuserlist.ui.createuser.CreateUserActivity;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListAdapter.Listener {

    private final List<User> mUsers = new ArrayList<>();
    private ActivityUserListBinding mBinding;
    private UserListAdapter mUserListAdapter;
    private UserListViewModel mUserListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        configureViewModel();
        configureRecyclerView();
        configureFAB();
    }

    private void configureViewModel() {
        mUserListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        mUserListViewModel.getUsers().observe(this, this::refreshUserList);
    }

    private void refreshUserList(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        mUserListAdapter.notifyDataSetChanged();
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
    public void onClickDeleteButton(int position) {
        mUserListViewModel.deleteUser(mUsers.get(position));
    }
}