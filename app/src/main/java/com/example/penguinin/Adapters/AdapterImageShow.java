package com.example.penguinin.Adapters;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.penguinin.Models.SearchModel;
import com.example.penguinin.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class AdapterImageShow extends RecyclerView.Adapter<AdapterImageShow.ViewHolder> {
    private ArrayList fetchResult;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView description;
        private final Button portfolio_url;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            imageView =(ImageView) view.findViewById(R.id.urlPhoto);
            description =(TextView) view.findViewById(R.id.tvDescription);
            portfolio_url = (Button) view.findViewById(R.id.btPortfolio);
        }

        public TextView getTextView() {
            return description;
        }
        public ImageView getImageView() {
            return imageView;
        }
        public Button getPortfolio_url() {
            return portfolio_url;
        }
    }
    public AdapterImageShow(ArrayList<SearchModel>searchModels) {
        fetchResult = searchModels;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_image_carsuol, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,  int position) {
        JSONArray arrData=null;
        try {
            arrData = new JSONArray(new Gson().toJson(fetchResult));
            JSONObject jObj = null;
            assert arrData != null;
            jObj = arrData.getJSONObject(0);
            String date = jObj.getString("results");
            Log.wtf("response_successdata",date);
            JSONArray arrParm = new JSONArray(date);
            // config photo description
            JSONObject jObjParm = arrParm.getJSONObject(position);
            // config image from url
            String imageUrl = jObjParm.getString("urls");
            JSONObject imgUrlParm = new JSONObject(imageUrl);
            String jObjImgUrlParm = imgUrlParm.getString("regular");
            if (jObjImgUrlParm != "") {
                Bitmap bitmap = null;
                InputStream inputStream = null;
                Log.wtf("response_success22",jObjImgUrlParm);
                Picasso.get().load(jObjImgUrlParm).into(holder.imageView);
            }
            // config user portfolio and open user portfolio website
            String user = jObjParm.getString("user");
            JSONObject arrUserParm = new JSONObject(user);
            String jObjUserParm = arrUserParm.getString("links");
            JSONObject arrUserLibksParm = new JSONObject(jObjUserParm);
            String jObjUserLinksParm = arrUserLibksParm.getString("html");
            Log.wtf("response_successlink22",jObjUserLinksParm);
            if (!jObjUserLinksParm.equals("")){
                holder.portfolio_url.setVisibility(View.VISIBLE);
                holder.portfolio_url.setText(R.string.user_portfolio);
                holder.portfolio_url.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(jObjUserLinksParm);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        holder.imageView.getContext().startActivity(intent);
                    }
                });
            }
            else {
                holder.portfolio_url.setText("");

            }
            String description = jObjParm.getString("description");
            if (description != "" || description != null){
                holder.description.setText(holder.itemView.getContext().getResources().getString(R.string.photo_description)+"\n"+description);
            }
          
        } catch (JSONException e) {
            e.printStackTrace();
            Log.wtf("response_error22",e.getMessage());
        }
    }
    @Override
    public int getItemCount() {
        return 10;
    }
    private void configJson(){

    }
}

