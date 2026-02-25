module com.example.demo_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo_javafx to javafx.fxml;

    exports com.example.demo_javafx;

    exports com.example.demo_javafx.controllers;
    opens com.example.demo_javafx.controllers to javafx.fxml;
}