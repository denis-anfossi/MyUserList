package com.denisanfossi.myuserlist.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denisanfossi.myuserlist.databinding.ItemUserListBinding;
import com.denisanfossi.myuserlist.model.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {

    private final List<User> mUsers;
    private final Listener mCallback;

    public UserListAdapter(List<User> users, Listener callback) {
        mUsers = users;
        mCallback = callback;
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserListBinding binding = ItemUserListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserListViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.bind(mUsers.get(position), mCallback);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public interface Listener {
        void onClickDeleteButton(int position);
    }
}
