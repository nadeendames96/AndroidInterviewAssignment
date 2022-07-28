package com.example.penguinin.Constant;
import android.util.Log;

import com.example.penguinin.Models.SearchModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
public class MyApplicationConstant {
    public static String base_url = "https://api.unsplash.com/";
    public static final String access_kry = "yhwCfH0fcXizUkqb1Ml9xunjl-8OsNVhbypy0QjBHvI";
    public static ArrayList fetchResult =new ArrayList<SearchModel>();
    public static boolean isNothingRef = false;
    public static String searchKeyword = "";
}
