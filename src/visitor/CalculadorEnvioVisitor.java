package visitor;

import model.*;

public class CalculadorEnvioVisitor implements Visitante {
    private double envio = 0;

    private double calcular(Producto p) {
        double porcentajeEnvio = (p.getPesoGramos() / 100.0) * 2;
        return p.getPrecio() * porcentajeEnvio / 100;
    }

    @Override public void visitar(Tablet t)             { envio += calcular(t); }
    @Override public void visitar(Portatil p)           { envio += calcular(p); }
    @Override public void visitar(ComputadoraTorre c)   { envio += calcular(c); }
    @Override public void visitar(Television tv)        { envio += calcular(tv); }

    public double getEnvio() { return envio; }
}
