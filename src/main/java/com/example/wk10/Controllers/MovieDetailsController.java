package com.example.wk10.Controllers;

import com.example.wk10.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MovieDetailsController {

    @FXML
    private ListView<?> actorsListView;

    @FXML
    private Label directorLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label movieNameLabel;

    @FXML
    private ListView<?> ratingsListView;

    @FXML
    private Label releasedDateLabel;

    @FXML
    private Label runtimeLabel;

    @FXML
    private Label writerLabel;

    @FXML
    private Label yearLabel;

    public void displayMovieData(String imdbID) {
        System.out.println("Selected Movie ID from first scene (Inside second scene): " +  imdbID);
    }

    @FXML
    void goBackButton_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event ,"search-view.fxml", "Search View", "-1");
    }

}

