package com.example.wk10.Models;

import com.example.wk10.Models.Movie;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("Search")
    private Movie[] movie;
    private String totalResults;
    @SerializedName("Response")
    private String response;

    public Movie[] getMovie() {
        return movie;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }
}
