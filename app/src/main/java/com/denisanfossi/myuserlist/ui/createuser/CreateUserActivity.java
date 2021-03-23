package com.denisanfossi.myuserlist.ui.createuser;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.denisanfossi.myuserlist.databinding.ActivityCreateUserBinding;
import com.denisanfossi.myuserlist.model.User;

public class CreateUserActivity extends AppCompatActivity {

    private ActivityCreateUserBinding mBinding;
    private CreateUserViewModel mCreateUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCreateUserBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        configureViewModel();
        configureListener();
    }

    private void configureViewModel() {
        mCreateUserViewModel = new ViewModelProvider(this).get(CreateUserViewModel.class);
    }

    private void configureListener() {
        mBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mBinding.nameEdittext.getText().toString();
                if (!name.isEmpty()) {
                    String avatarUrl = "https://avatars.dicebear.com/api/bottts/" + name + ".png";
                    User user = new User(name, avatarUrl);
                    mCreateUserViewModel.createUser(user);
                    finish();
                }
            }
        });
    }

}