package visitor;

import model.*;

public class CalculadorSubtotalVisitor implements Visitante {
    private double subtotal = 0;

    @Override public void visitar(Tablet t)             { subtotal += t.getPrecio(); }
    @Override public void visitar(Portatil p)           { subtotal += p.getPrecio(); }
    @Override public void visitar(ComputadoraTorre c)   { subtotal += c.getPrecio(); }
    @Override public void visitar(Television tv)        { subtotal += tv.getPrecio(); }

    public double getSubtotal() { return subtotal; }
}
