package com.example.demo_javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    public void onGotoForm(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_javafx/form-view.fxml"));
            Scene formScene = new Scene(loader.load(),350,580);
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(formScene);
            stage.show();

        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
