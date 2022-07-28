package com.example.penguinin.Models;

public class PhotoModel {
    private long total;
    private long totalPages;
    private Result[] results;

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public long getTotalPages() { return totalPages; }
    public void setTotalPages(long value) { this.totalPages = value; }

    public Result[] getResults() { return results; }
    public void setResults(Result[] value) { this.results = value; }
}
