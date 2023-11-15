package com.example.wk10.Controllers;

import com.example.wk10.Models.MovieDetail;
import com.example.wk10.Models.Rating;
import com.example.wk10.Utilities.ApiUtility;
import com.example.wk10.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MovieDetailsController {

    @FXML
    private ListView<String> actorsListView;

    @FXML
    private Label directorLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label movieNameLabel;

    @FXML
    private ListView<Rating> ratingsListView;

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

        MovieDetail movieDetail = ApiUtility.getMovieDetailsFromAPI(imdbID);

        // add movie name header
        movieNameLabel.setText(movieDetail.getTitle());

        // add left side data
        yearLabel.setText(movieDetail.getYear());
        releasedDateLabel.setText(movieDetail.getReleasedDate());
        runtimeLabel.setText(movieDetail.getRuntime());
        genreLabel.setText(movieDetail.getGenre());
        directorLabel.setText(movieDetail.getDirector());
        writerLabel.setText(movieDetail.getWriter());

        // add center data (image)
        try {
            imageView.setImage(new Image(movieDetail.getPoster()));
        } catch (Exception e) {
            imageView.setImage(new Image("wk10/src/main/resources/img/stock-vector-flat-icon-nothing-here-page-not-found-2269630539.jpg"));
            e.printStackTrace();
        }

        // add right side data (list views)
        String actorsString = movieDetail.getActors();
        String[] actorsArray = actorsString.split(", ");
        actorsListView.getItems().addAll(actorsArray);

        ratingsListView.getItems().addAll(movieDetail.getRatings());
    }

    @FXML
    void goBackButton_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event ,"search-view.fxml", "Search View", "-1");
    }

}

