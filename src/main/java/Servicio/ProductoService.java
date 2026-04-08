package Servicio;

import Modelo.Producto;
import Repositorio.FileRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductoService {

    // Lista observable para JavaFX
    private ObservableList<Producto> productos;

    private FileRepository repository;

    public ProductoService() {
        repository = new FileRepository();

        List<Producto> datosCargados = repository.leer();

        // Convertimos a ObservableList
        productos = FXCollections.observableArrayList(datosCargados);
    }

    public ObservableList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto p) {

        validarProducto(p);

        for (Producto existente : productos) {
            if (existente.getCodigo().equals(p.getCodigo())) {
                throw new IllegalArgumentException("Error: el código ya existe -> " + p.getCodigo());
            }
        }

        productos.add(p);
        repository.guardar(productos);
    }

    public void actualizarProducto(Producto pActualizado) {

        validarProducto(pActualizado);

        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getCodigo().equals(pActualizado.getCodigo())) {

                productos.set(i, pActualizado);
                repository.guardar(productos);
                return;
            }
        }

        throw new IllegalArgumentException("Producto no encontrado");
    }

    public void eliminarProducto(Producto p) {

        productos.removeIf(prod -> prod.getCodigo().equals(p.getCodigo()));

        repository.guardar(productos);
    }

    private void validarProducto(Producto p) {

        if (p.getCodigo() == null || p.getCodigo().trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (p.getNombre() == null || p.getNombre().trim().length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }

        if (p.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (p.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        if (p.getCategoria() == null || p.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
    }
}
