package service;

import modelo.Producto;
import repository.ProductoRepository;

import java.util.List;

public class ProductoService {

    private final ProductoRepository repo = new ProductoRepository();

    public ProductoService() {
        repo.load(); // carga inicial del CSV
    }

    // ================= LISTAR =================
    public List<Producto> listar() {
        return repo.findAll();
    }

    // ================= CREAR =================
    public String crear(Producto p) {

        if (p.getCodigo().isBlank() ||
                p.getNombre().isBlank() ||
                p.getCategoria().isBlank()) {
            return "Campos vacíos";
        }

        if (p.getNombre().length() < 3) {
            return "Nombre muy corto";
        }

        if (p.getPrecio() <= 0) return "Precio inválido";
        if (p.getStock() < 0) return "Stock inválido";

        boolean ok = repo.add(p);

        if (ok) {
            repo.load(); //refresca memoria después de guardar
            return "OK";
        }

        return "Código duplicado";
    }

    // ================= ELIMINAR =================
    public boolean eliminar(String codigo) {
        boolean ok = repo.delete(codigo);
        repo.load(); //refresca después de eliminar
        return ok;
    }

    // ================= ACTUALIZAR =================
    public boolean actualizar(Producto p) {
        boolean ok = repo.update(p);
        repo.load(); //refresca después de editar
        return ok;
    }

    // ================= RECARGAR =================
    public void recargar() {
        repo.load(); //SIEMPRE relee CSV
    }
}