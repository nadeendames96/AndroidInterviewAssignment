package com.example.penguinin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.penguinin.Activities.HomeActivity;
import com.example.penguinin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(mainBinding.getRoot());
        init();
    }
    private void init(){
        {
            Thread splashThread = new Thread(() -> {
          try {
              Thread.sleep(3*1000);
              Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
              startActivity(intent);
              mainBinding.loading.setVisibility(View.GONE);
              finish();
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
            });
            splashThread.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}