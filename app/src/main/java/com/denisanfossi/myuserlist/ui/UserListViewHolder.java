package com.denisanfossi.myuserlist.ui;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.denisanfossi.myuserlist.databinding.ItemUserListBinding;
import com.denisanfossi.myuserlist.model.User;

public class UserListViewHolder extends RecyclerView.ViewHolder {

    private final ItemUserListBinding mBinding;

    public UserListViewHolder(@NonNull ItemUserListBinding binding) {
        super(binding.getRoot());

        mBinding = binding;
    }

    public void bind(User user) {
        mBinding.itenNameTextview.setText(user.getName());
        Glide.with(mBinding.itemAvatarImageview).load(user.getAvatarUrl()).into(mBinding.itemAvatarImageview);
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserProfileActivity.class);
                intent.putExtra("user", user);
                view.getContext().startActivity(intent);
            }
        });
    }
}
