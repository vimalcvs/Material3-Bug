package com.example.appmain;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    SaveState saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveState = new SaveState(this);

        if (saveState.getState()){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        SwitchButton switchBtn = findViewById(R.id.switch_btn);
        if (saveState.getState()){
            switchBtn.setChecked(true);
        }
        switchBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                saveState.setState(true);
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else{
                saveState.setState(false);
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        MaterialButton materialButton = findViewById(R.id.textView);
        materialButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(this, TargetActivity.class);
            startActivity(myIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        });
    }
}