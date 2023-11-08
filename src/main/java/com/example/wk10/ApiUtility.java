package com.example.wk10;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ApiUtility {
    /*
    This function will force the json data from a file and create object from that
     */
    public static ApiResponse getDataFromFile(String fileName) {
        ApiResponse response = null;
        Gson gson = new Gson();

        // try with resource block
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                ) {
            response = gson.fromJson(jsonReader, ApiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /*
    This method will accept search term from user and pass json data from file to create object
     */
    public static ApiResponse getDataFromAPI(String searchName) {
        searchName = searchName.replaceAll(" ", "%20");
        String uri = "http://www.omdbapi.com/?apikey=12b8ac5c&s=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDataFromFile("javaApiFetched.json");
    }
}
