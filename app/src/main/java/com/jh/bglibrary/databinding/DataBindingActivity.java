package com.jh.bglibrary.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jh.bglibrary.R;
import com.jh.bglibrary.databinding.ActivityDataBindingBinding;
import com.noober.background.BackgroundLibrary;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        User user = new User();
        user.setName("xxx");
        binding.setUser(user);
    }
}
