package controlador;

import Modelo.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class FormularioController {
    @FXML private TextField txtCodigo, txtNombre, txtPrecio, txtStock, txtCategoria;
    @FXML private Button btnGuardar, btnCancelar;

    private Producto producto;
    private boolean guardado = false;

    @FXML
    public void initialize() {
        btnCancelar.setOnAction(e -> ((Stage) btnCancelar.getScene().getWindow()).close());
        btnGuardar.setOnAction(e -> guardar());
    }

    private void guardar() {
        // Extraemos los textos quitando espacios en blanco a los lados con .trim()
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String stockStr = txtStock.getText().trim();
        String categoria = txtCategoria.getText().trim();

        // VALIDACIÓN 1: No permitir campos vacíos
        if (codigo.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty() || categoria.isEmpty()) {
            mostrarAlerta("Campos Obligatorios", "Por favor, no dejes campos vacíos. Todos son obligatorios.");
            return; // El "return" detiene la ejecución para que no se guarde nada
        }

        // VALIDACIÓN 2: Nombre del producto con mínimo 3 caracteres
        if (nombre.length() < 3) {
            mostrarAlerta("Nombre demasiado corto", "El nombre del producto debe tener al menos 3 caracteres.");
            return;
        }

        // VALIDACIÓN 3: Asegurarnos de que Precio y Stock sean números válidos
        try {
            double precio = Double.parseDouble(precioStr);
            int stock = Integer.parseInt(stockStr);

            // Si pasa todas las validaciones, creamos el producto y cerramos la ventana
            producto = new Producto(codigo, nombre, precio, stock, categoria);
            guardado = true;
            ((javafx.stage.Stage) btnGuardar.getScene().getWindow()).close();

        } catch (NumberFormatException ex) {
            // Esta alerta salta si el usuario escribe letras en los campos de números
            mostrarAlerta("Error de Formato", "El precio y el stock deben ser números válidos.");
        }
    }

    // Método auxiliar para crear las ventanitas de alerta fácilmente
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setProductoEdicion(Producto p) {
        this.producto = p; // Guardamos la referencia
        // Rellenamos los campos con la información actual
        txtCodigo.setText(p.getCodigo());
        txtNombre.setText(p.getNombre());
        txtPrecio.setText(String.valueOf(p.getPrecio()));
        txtStock.setText(String.valueOf(p.getStock()));
        txtCategoria.setText(p.getCategoria());

        // El código no debería editarse (opcional, por seguridad)
        txtCodigo.setEditable(false);
    }

    public Producto getProducto() { return producto; }
    public boolean isGuardado() { return guardado; }
}