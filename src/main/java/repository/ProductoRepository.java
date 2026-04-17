package repository;

import modelo.Producto;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();
    private final String FILE_PATH = "data/productos.csv";

    // ================= CARGAR =================
    public void load() {
        productos.clear();

        try {
            Path path = Paths.get(FILE_PATH);

            if (!Files.exists(path)) return;

            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                String[] p = line.split(",");

                if (p.length == 5) {
                    productos.add(new Producto(
                            p[0],
                            p[1],
                            Double.parseDouble(p[2]),
                            Integer.parseInt(p[3]),
                            p[4]
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // ================= GUARDAR =================
    public void saveAll() {
        try {
            Path path = Paths.get(FILE_PATH);

            Files.createDirectories(path.getParent()); //  CREA CARPETA

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Producto p : productos) {
                bw.write(
                        p.getCodigo() + "," +
                                p.getNombre() + "," +
                                p.getPrecio() + "," +
                                p.getStock() + "," +
                                p.getCategoria()
                );
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error guardando archivo: " + e.getMessage());
        }
    }

    // ================= CRUD =================
    public List<Producto> findAll() {
        return productos;
    }

    public boolean add(Producto p) {
        if (findByCode(p.getCodigo()) != null) return false;

        productos.add(p);
        saveAll();
        return true;
    }

    public boolean delete(String codigo) {
        Producto p = findByCode(codigo);
        if (p == null) return false;

        productos.remove(p);
        saveAll();
        return true;
    }

    public boolean update(Producto nuevo) {
        Producto p = findByCode(nuevo.getCodigo());
        if (p == null) return false;

        p.setNombre(nuevo.getNombre());
        p.setPrecio(nuevo.getPrecio());
        p.setStock(nuevo.getStock());
        p.setCategoria(nuevo.getCategoria());

        saveAll();
        return true;
    }

    public Producto findByCode(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }
}