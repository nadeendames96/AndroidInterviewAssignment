package com.example.penguinin.Activities;
import static com.example.penguinin.Constant.MyApplicationConstant.access_kry;
import static com.example.penguinin.Constant.MyApplicationConstant.fetchResult;
import static com.example.penguinin.Constant.MyApplicationConstant.searchKeyword;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.penguinin.Constant.MyApplicationConstant;
import com.example.penguinin.Models.ImageModel;
import com.example.penguinin.Models.SearchModel;
import com.example.penguinin.R;
import com.example.penguinin.Services.RetrofitClient;
import com.example.penguinin.Services.UnSplashApi;
import com.example.penguinin.databinding.ActivityHomeBinding;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding homeBinding;
    Button searchNow ;
    EditText searchWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        setContentView(homeBinding.getRoot());
        init();
    }
    private void init(){
    setIDs();
    setActions();
    }
    private void setIDs(){
        searchNow = findViewById(R.id.btSearch);
        searchWord = findViewById(R.id.etSearch);
    }
    private void setActions(){
        searchNow.setOnClickListener(v -> {
            if (homeBinding.etSearch.getText().toString().equals("")){
                new AlertDialog.Builder(this)
                        .setMessage(getString(R.string.fill_search))
                        .setNegativeButton(R.string.ok, null)
                        .create().show();
            }
            else{
                searchPhoto();
            }
        });
        homeBinding.clearText.setOnClickListener(v -> homeBinding.etSearch.setText(""));
    }
    private  void searchPhoto(){
        String query = searchWord.getText().toString();
        RetrofitClient.getRetrofitInstance().create(UnSplashApi.class).getAllPhotos(query.toLowerCase(),access_kry).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                fetchResult.clear();
                fetchResult.add(response.body());
                searchKeyword = query;
                Intent intent = new Intent(getApplicationContext(),ResultIsSearchActivity.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                Log.wtf("response_error",t.toString());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.exit))
                .setMessage(getString(R.string.do_exit))
                .setNegativeButton(R.string.no, null)
                .setPositiveButton(R.string.yes , (dialog, id) -> {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }).create().show();
    }
}