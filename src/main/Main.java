package main;

import model.*;
import visitor.*;

public class Main {
    public static void main(String[] args) {
        Tablet tablet = new Tablet("Tablet", 200, 250);
        Portatil portatil = new Portatil("Computador portatil", 400, 1000);
        ComputadoraTorre torre = new ComputadoraTorre("Computador de torre", 600, 6000);
        Television tv = new Television("Televisión", 300, 4000);

        Pedido pedido = new Pedido();
        pedido.agregar(tablet, 2);
        pedido.agregar(portatil, 1);
        pedido.agregar(torre, 1);
        pedido.agregar(tv, 1);

        CalculadorSubtotalVisitor subtotalV = new CalculadorSubtotalVisitor();
        pedido.aceptar(subtotalV);

        CalculadorEnvioVisitor envioV = new CalculadorEnvioVisitor();
        pedido.aceptar(envioV);

        double subtotal = subtotalV.getSubtotal();
        double envio = envioV.getEnvio();

        System.out.println("===== PEDIDO WTECH =====");
        System.out.printf("Subtotal: $%.0f%n", subtotal);
        System.out.printf("Envio:    $%.0f%n", envio);
        System.out.printf("Total:    $%.0f%n", subtotal + envio);

        // Pedido vacío
        Pedido vacio = new Pedido();
        CalculadorSubtotalVisitor s0 = new CalculadorSubtotalVisitor();
        CalculadorEnvioVisitor e0 = new CalculadorEnvioVisitor();
        vacio.aceptar(s0);
        vacio.aceptar(e0);
        System.out.println("\n===== PEDIDO VACIO =====");
        System.out.printf("Subtotal: $%.0f | Envío: $%.0f | Total: $%.0f%n",
                s0.getSubtotal(), e0.getEnvio(), s0.getSubtotal() + e0.getEnvio());

        System.out.println("\n===== CANTIDAD INVALIDA =====");
        try {
            pedido.agregar(tablet, 0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error controlado: " + ex.getMessage());
        }
    }
}
