    package com.example.demoss.controllers;

    import com.example.demoss.services.PersonService;
    import javafx.beans.Observable;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.scene.control.Label;
    import javafx.scene.control.ListView;

    import java.io.IOException;
    import java.util.List;


    public class AppControllers {

        @FXML
        private Label lblmsg;


        @FXML
        private ListView<String> listView;


        @FXML
        public void initialize(){
            listView.setItems(data);
                loadFromFile();
        }

        private ObservableList<String > data = FXCollections.observableArrayList();
        PersonService service= new PersonService();


        private void loadFromFile(){
            try{
                List<String> items = service.loadforlistView();
                data.setAll(items);
                lblmsg.setText("Datos cargados correctamente");
                lblmsg.setStyle("-fx-text-fill: green");

            }catch (IOException e){

                lblmsg.setText("Error");
                lblmsg.setStyle("-fx-text-fill: red");
            }


        }
    }
