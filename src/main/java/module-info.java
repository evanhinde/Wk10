module com.example.wk10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wk10 to javafx.fxml;
    exports com.example.wk10;
}