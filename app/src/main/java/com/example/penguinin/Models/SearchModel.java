package com.example.penguinin.Models;

import java.util.ArrayList;

public class SearchModel {
    private ArrayList<Result> results;
    public SearchModel(ArrayList<Result> results){
        this.results = results;
    }
    public ArrayList<Result> getResults(){
        return this.results;
    }
    public void setResults(ArrayList<Result>results){
        this.results = results;
    }
}
