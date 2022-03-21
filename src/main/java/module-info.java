module com.example.carracing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carracing to javafx.fxml;
    exports com.example.carracing;
}