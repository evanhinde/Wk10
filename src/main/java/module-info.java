module com.example.wk10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.wk10 to javafx.fxml, com.google.gson;
    exports com.example.wk10;
}