package com.example.wk10;

import com.google.gson.annotations.SerializedName;

public class Movie {
    /*"Title": "Operation Dunkirk",
            "Year": "2017",
            "imdbID": "tt6836772",
            "Type": "movie",
            "Poster": "https://m.media-amazon.com/images/M/MV5BOGUxMDZjYTgtM2Q0MS00ZTRiLThkYzktNDQ3ZGMzMjY0ZjIyXkEyXkFqcGdeQXVyNTM3MDMyMDQ@._V1_SX300.jpg"*/
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    private String imdbID;
    @SerializedName("Poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getPoster() {
        return poster;
    }
}
