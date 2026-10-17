package model;

import visitor.Visitante;

/** Producto concreto: solo almacena datos, sin lógica de negocio. */
public class Portatil implements Producto {
    private final String nombre;
    private final double precio;
    private final int pesoGramos;

    public Portatil(String nombre, double precio, int pesoGramos) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoGramos = pesoGramos;
    }

    @Override public String getNombre() { return nombre; }
    @Override public double getPrecio() { return precio; }
    @Override public int getPesoGramos() { return pesoGramos; }

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this);
    }
}
