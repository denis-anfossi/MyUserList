package com.denisanfossi.myuserlist.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denisanfossi.myuserlist.data.repository.UsersRepository;
import com.denisanfossi.myuserlist.databinding.ActivityCreateUserBinding;
import com.denisanfossi.myuserlist.di.Injection;
import com.denisanfossi.myuserlist.model.User;

public class CreateUserActivity extends AppCompatActivity {

    private ActivityCreateUserBinding mBinding;
    private UsersRepository mUsersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCreateUserBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mUsersRepository = Injection.getUsersRepository();
        mBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mBinding.nameEdittext.getText().toString();
                if (!name.isEmpty()) {
                    Long id = mUsersRepository.getUsers().get(mUsersRepository.getUsers().size() - 1).getId() + 1;
                    String avatarUrl = "https://avatars.dicebear.com/api/bottts/" + name + ".png";
                    User user = new User(id, name, avatarUrl);
                    mUsersRepository.createUser(user);
                    finish();
                }
            }
        });
    }

}