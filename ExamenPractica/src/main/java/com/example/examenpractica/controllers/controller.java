package com.example.examenpractica.controllers;

import com.example.examenpractica.contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class controller {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private ListView<contacto> listView;
    @FXML private Label lblMensaje;

    private ObservableList<contacto> listaContactos = FXCollections.observableArrayList();

    private String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(parentescos);
        listView.setItems(listaContactos);
    }

    private boolean validar(String nombre, String telefono, String parentesco) {
        if (nombre.isEmpty()) return false;
        if (telefono.isEmpty()) return false;
        if (!telefono.matches("\\d{10}")) return false;
        if (parentesco == null) return false;
        return true;
    }

    @FXML
    public void agregar() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parentesco = cmbParentesco.getValue();

        if (!validar(nombre, telefono, parentesco)) return;

        for (contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return;
        }

        listaContactos.add(new contacto(nombre, telefono, parentesco));
        limpiar();
    }

    @FXML
    public void buscar() {
        String nombre = txtNombre.getText();

        for (contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                txtTelefono.setText(c.getTelefono());
                cmbParentesco.setValue(c.getParentesco());
                return;
            }
        }
    }

    @FXML
    public void actualizar() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parentesco = cmbParentesco.getValue();

        if (!validar(nombre, telefono, parentesco)) return;

        for (contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.setTelefono(telefono);
                c.setParentesco(parentesco);
                listView.refresh();
                limpiar();
                return;
            }
        }
    }

    @FXML
    public void eliminar() {
        String nombre = txtNombre.getText();

        contacto eliminar = null;

        for (contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                eliminar = c;
                break;
            }
        }

        if (eliminar != null) {
            listaContactos.remove(eliminar);
            limpiar();
        }
    }

    @FXML
    public void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }
}