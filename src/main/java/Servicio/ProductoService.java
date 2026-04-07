package Servicio;

import Modelo.Producto;
import Repositorio.FileRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    // Lista en memoria donde se guardan los productos
    private List<Producto> productos;

    // Repositorio encargado de leer y guardar en archivo (CSV)
    private FileRepository repository;

    // Constructor: se ejecuta al crear el servicio
    public ProductoService() {
        repository = new FileRepository(); // Inicializa el repositorio

        List<Producto> datosCargados = repository.leer(); // Lee datos del archivo

        productos = new ArrayList<>(datosCargados); // Guarda los datos en memoria
    }

    // Método para obtener todos los productos
    public List<Producto> getProductos() {
        return productos; // Retorna la lista completa
    }

    // Método para agregar un producto
    public void agregarProducto(Producto p) throws IllegalArgumentException {

        validarProducto(p); // Valida los datos del producto

        // Verifica que no exista otro producto con el mismo código
        for (Producto existente : productos) {
            if (existente.getCodigo().equals(p.getCodigo())) {
                throw new IllegalArgumentException("Error: el código ya existe -> " + p.getCodigo());
            }
        }

        productos.add(p); // Agrega el producto a la lista

        repository.guardar(productos); // Guarda los cambios en el archivo
    }

    // Método para actualizar un producto
    public void actualizarProducto(Producto pActualizado) throws IllegalArgumentException {

        validarProducto(pActualizado); // Valida el producto actualizado

        // Busca el producto por su código
        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getCodigo().equals(pActualizado.getCodigo())) {

                productos.set(i, pActualizado); // Reemplaza el producto

                repository.guardar(productos); // Guarda cambios en archivo
                return;
            }
        }

        // Si no se encuentra el producto
        throw new IllegalArgumentException("Producto no encontrado para actualizar");
    }

    // Método para eliminar un producto
    public void eliminarProducto(Producto p) {

        // Elimina el producto comparando por código
        productos.removeIf(prod -> prod.getCodigo().equals(p.getCodigo()));

        repository.guardar(productos); // Guarda cambios en archivo
    }

    // Método privado para validar datos del producto
    private void validarProducto(Producto p) throws IllegalArgumentException {

        // Validar código
        if (p.getCodigo() == null || p.getCodigo().trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        // Validar nombre
        if (p.getNombre() == null || p.getNombre().trim().length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }

        // Validar precio
        if (p.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        // Validar stock
        if (p.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        // Validar categoría
        if (p.getCategoria() == null || p.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
    }
}