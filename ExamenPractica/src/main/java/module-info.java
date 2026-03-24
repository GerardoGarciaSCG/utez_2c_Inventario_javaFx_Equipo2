module com.example.examenpractica {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.examenpractica.controllers to javafx.fxml;

    exports com.example.examenpractica;
}