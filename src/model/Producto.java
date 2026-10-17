package model;

import visitor.Visitante;

public interface Producto {
    String getNombre();
    double getPrecio();
    int getPesoGramos();

    void aceptar(Visitante v);
}
