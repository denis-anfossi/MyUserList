package com.denisanfossi.myuserlist.ui;

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
    }
}
