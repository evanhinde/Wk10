package com.example.wk10.Controllers;

import com.example.wk10.Models.Movie;
import com.example.wk10.Models.ApiResponse;
import com.example.wk10.Utilities.ApiUtility;
import com.example.wk10.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController  implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Movie> listView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button getDetailsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        getDetailsButton.setVisible(false);
        listView.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldMovie, newMovie) ->  {
                    getDetailsButton.setVisible(true);
                    try {
                        imageView.setImage(new Image(newMovie.getPoster()));
                    } catch (Exception e) {
                        //imageView.setImage("wk10/src/main/resources/img/stock-vector-flat-icon-nothing-here-page-not-found-2269630539.jpg");
                        e.printStackTrace();
                    }
                })
        );
    }
    @FXML
    void showMovies(ActionEvent event) {
        listView.getItems().clear();
        String searchString = searchTextField.getText();
        // create apiResponse object
        ApiResponse apiResponse = ApiUtility.getDataFromAPIQuick(searchString);

        // add movie objects to listView
        if (apiResponse.getMovie() == null) {
            errorLabel.setVisible(true);
            errorLabel.setText("No Movies Found");
        } else {
            listView.getItems().addAll(apiResponse.getMovie());
            errorLabel.setVisible(false);
        }
    }

    @FXML
    void getDetailsButton_onClick(ActionEvent event) throws IOException {
        String selectedID = listView.getSelectionModel().getSelectedItem().getImdbID();
        System.out.println("Selected Movie ID (From first scene): " + selectedID);
        SceneChanger.changeScene(event ,"movie-details-view.fxml", "Movie Details", selectedID);
    }


}

