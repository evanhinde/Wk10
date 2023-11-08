package com.example.wk10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        ApiResponse apiResponse = ApiUtility.getDataFromFile("apiData.json");
        System.out.println(apiResponse);
    }
}