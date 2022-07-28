package com.example.penguinin.Services;

import static com.example.penguinin.Constant.MyApplicationConstant.access_kry;

import com.example.penguinin.Models.ImageModel;
import com.example.penguinin.Models.SearchModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UnSplashApi {
    @Headers("Authorization: Client-ID" + access_kry)
    @GET("search/photos")
    Call<SearchModel> getAllPhotos(
            @Query("query") String query,
            @Query("client_id") String client_id
    );
}
