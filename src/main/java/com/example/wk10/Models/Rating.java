package com.example.wk10.Models;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("Source")
    private String source;
    @SerializedName("Value")
    private String value;

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", value, source);
    }
}
