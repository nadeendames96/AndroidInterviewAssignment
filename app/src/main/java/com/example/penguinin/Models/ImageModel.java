package com.example.penguinin.Models;

public class ImageModel {
    private Urls urls;
    public ImageModel(Urls urls){
        this.urls = urls;
    }
    public  Urls getUrls(){
        return urls;
    }
    public void setUrls(){
        this.urls = urls;
    }
}
