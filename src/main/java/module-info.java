module com.example.wk10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.wk10 to javafx.fxml, com.google.gson;
    exports com.example.wk10;
    exports com.example.wk10.Utilities;
    opens com.example.wk10.Utilities to com.google.gson, javafx.fxml;
    exports com.example.wk10.Models;
    opens com.example.wk10.Models to com.google.gson, javafx.fxml;
    exports com.example.wk10.Controllers;
    opens com.example.wk10.Controllers to com.google.gson, javafx.fxml;
}