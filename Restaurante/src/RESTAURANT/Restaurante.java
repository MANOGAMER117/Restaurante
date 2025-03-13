/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RESTAURANT;

/**
 *
 * @author zohan
 */
import java.util.*;

class Restaurante {
    static class Pedido {
        String nombre;
        List<String> items;
        boolean entregado;

        Pedido(String nombre, List<String> items) {
            this.nombre = nombre;
            this.items = items;
            this.entregado = false;
        }
    }

    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(String nombre, List<String> items) {
        Pedido nuevoPedido = new Pedido(nombre, items);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido agregado para " + nombre);
    }

    public void procesarPedidos() {
        for (Pedido pedido : pedidos) {
            if (!pedido.entregado) {
                System.out.println("Procesando pedido de " + pedido.nombre);
                for (String item : pedido.items) {
                    System.out.println("  Preparando: " + item);
                    if (item.equals("Pizza")) {
                        System.out.println("    Horneando pizza...");
                        for (int i = 0; i < 3; i++) {
                            System.out.println("      Minuto " + (i + 1));
                        }
                    } else if (item.equals("Ensalada")) {
                        System.out.println("    Cortando ingredientes...");
                        for (String ingrediente : Arrays.asList("Lechuga", "Tomate", "Zanahoria")) {
                            System.out.println("      Agregando " + ingrediente);
                        }
                    }
                }
                pedido.entregado = true;
                System.out.println("Pedido de " + pedido.nombre + " entregado.");
            }
        }
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        restaurante.agregarPedido("Carlos", Arrays.asList("Pizza", "Ensalada"));
        restaurante.agregarPedido("Ana", Arrays.asList("Hamburguesa"));
        restaurante.procesarPedidos();
    }
}