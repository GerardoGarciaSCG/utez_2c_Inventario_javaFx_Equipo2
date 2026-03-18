package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Label lblMsg;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;

    private final ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();

    @FXML
    public void initialize() {
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    String[] parts = newValue.split("-");
                    txtName.setText(parts[0]);
                    txtEmail.setText(parts[1]);
                    txtEdad.setText(parts[2]);

                }
        );
        loadFromFile();
    }

    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edadTexto = txtEdad.getText();
            if (edadTexto.isBlank()) {
                throw new IllegalArgumentException("La edad es obligatoria");
            }
            int edad = Integer.parseInt(edadTexto);
            service.addPerson(name, email, edad);

            lblMsg.setText("Persona agregada con éxito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();

            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("Error: La edad debe ser un número");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Error de archivo: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException ex) {
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate() {
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            int a = Integer.parseInt(edad);
            service.updatePerson(index, name, email, a);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("Se actualizo el registro correctamente");
        } catch (IllegalArgumentException e ){
            lblMsg.setText("Hubo un erro con los datos "+e.getMessage());


        } catch (Exception e) {
            lblMsg.setText("Hubo error con el archivo");
        }
    }

    public void onRemove(){
        int index = listView.getSelectionModel().getSelectedIndex();

        try {
            service.removePerson(index);
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();

            loadFromFile();
            lblMsg.setText("Persona eliminada");

        }catch (NumberFormatException e){
            lblMsg.setText("La edad tiene que ser un numero");
        }catch (IOException | IllegalArgumentException e ){
            lblMsg.setText("Error0" + e.getMessage());
        }
    }



    @FXML
    private void loadFromFile() {
        try {
            List<String> items = service.loadDataforList();
            if (items != null) {
                data.setAll(items);
            }
            if (lblMsg != null) {
                lblMsg.setText("Datos actualizados y agregados");
                lblMsg.setStyle("-fx-text-fill: purple;");
            }
        } catch (IOException e) {
            if (lblMsg != null) {
                lblMsg.setText("Error al cargar: " + e.getMessage());
                lblMsg.setStyle("-fx-text-fill: red;");
            }
            e.printStackTrace();
        }
    }
}