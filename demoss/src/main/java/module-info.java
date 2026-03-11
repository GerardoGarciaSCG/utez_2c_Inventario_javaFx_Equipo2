module com.example.demoss {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.demoss to javafx.fxml;
    opens com.example.demoss.services to javafx.fxml;
    opens com.example.demoss.repositories to javafx.fxml;
    opens com.example.demoss.controllers to javafx.fxml;



    exports com.example.demoss;
    exports com.example.demoss.services;
    exports com.example.demoss.controllers;
    exports com.example.demoss.repositories;
}