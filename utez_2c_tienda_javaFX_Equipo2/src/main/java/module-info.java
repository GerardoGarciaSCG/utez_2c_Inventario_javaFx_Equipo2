module com.example.utez_2c_tienda_javafx_equipo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.utez_2c_tienda_javafx_equipo2 to javafx.fxml;
    exports com.example.utez_2c_tienda_javafx_equipo2;
}