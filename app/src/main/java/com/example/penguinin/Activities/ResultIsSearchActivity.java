package com.example.penguinin.Activities;

import static com.example.penguinin.Constant.MyApplicationConstant.fetchResult;
import static com.example.penguinin.Constant.MyApplicationConstant.searchKeyword;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.penguinin.Adapters.AdapterImageShow;
import com.example.penguinin.R;
import com.example.penguinin.databinding.ActivityResultIsSearchBinding;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ResultIsSearchActivity extends AppCompatActivity {
ActivityResultIsSearchBinding searchBinding;
    TextView searchResult;
    ImageButton back;
    AdapterImageShow adapterImageShow;
    boolean isEmptyData = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         searchBinding = DataBindingUtil.setContentView(this,R.layout.activity_result_is_search);
        setContentView(searchBinding.getRoot());
    init();
    }
    private void init(){
        setIDs();
        setActions();
    }

    private void setUserMsg(){
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(getString(R.string.more_result))
                .setNegativeButton(R.string.ok, null)
                .create().show();
    }
    private void setIDs(){
        searchResult = findViewById(R.id.titleKeyword);
        back = findViewById(R.id.back);
    }
    private void setActions(){
        JSONArray arrData = null;
        try {
            arrData = new JSONArray(new Gson().toJson(fetchResult));
            JSONObject jObj = null;
            assert arrData != null;
            jObj = arrData.getJSONObject(0);
            String date = jObj.getString("results");
            Log.wtf("response_successdata",date);
            if (date.length()==2)
                isEmptyData =true;
        } catch (JSONException e) {
            e.printStackTrace();
            searchResult.setGravity(Gravity.CENTER_HORIZONTAL);

        }
        searchBinding.appbar.back.setVisibility(View.VISIBLE);
        searchBinding.appbar.back.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),HomeActivity.class)));
      if (!isEmptyData){
          searchResult.setText(getString(R.string.search)+":"+searchKeyword);
          adapterImageShow = new AdapterImageShow(fetchResult);
            searchBinding.rvImageShow.setHasFixedSize(true);
            searchBinding.rvImageShow.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            searchBinding.rvImageShow.setAdapter(adapterImageShow);
          setUserMsg();

      }
      else{
          searchResult.setText(getString(R.string.not_result));
          searchResult.setGravity(Gravity.CENTER_HORIZONTAL);
      }
       }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }

}
