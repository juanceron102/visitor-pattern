package model;

import visitor.Visitante;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        for (int i = 0; i < cantidad; i++) {
            productos.add(producto);
        }
    }

    public void aceptar(Visitante v) {
        for (Producto p : productos) {
            p.aceptar(v);
        }
    }
}
