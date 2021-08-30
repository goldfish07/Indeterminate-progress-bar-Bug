package com.example.bugdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button withTransBtn;
    Button withoutTransBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        withTransBtn = findViewById(R.id.withTransBtn);
        withoutTransBtn = findViewById(R.id.withoutTransBtn);
        withTransBtn.setOnClickListener(clickListener);
        withoutTransBtn.setOnClickListener(clickListener);


    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.withTransBtn){
                startActivityWithTransition(NewActivty.class);
            } else if (view.getId() == R.id.withoutTransBtn){
                startActivity(NewActivty.class);
            }
        }
    };

    public void startActivityWithTransition(Class<?> tClass) {
        Intent intent = new Intent(MainActivity.this, tClass);
        try {
            if (Build.VERSION.SDK_INT > 21) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            } else {
                startActivity(intent);
            }
        } catch (Exception e) {
            startActivity(intent);
        }
    }

    public void startActivity(Class<?> tClass) {
        Intent intent = new Intent(MainActivity.this, tClass);
        try {
            startActivity(intent);
        } catch (Exception e) {
            startActivity(intent);
        }
    }
}