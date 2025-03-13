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
        int mesa;

        Pedido(String nombre, List<String> items, int mesa) {
            this.nombre = nombre;
            this.items = items;
            this.entregado = false;
            this.mesa = mesa;
        }
    }

    private List<Pedido> pedidos = new ArrayList<>();
    private int totalMesas;

    public Restaurante(int totalMesas) {
        this.totalMesas = totalMesas;
    }

    public void agregarPedido(String nombre, List<String> items, int mesa) {
        Pedido nuevoPedido = new Pedido(nombre, items, mesa);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido agregado para " + nombre + " en la mesa " + mesa);
    }

    public void procesarPedidos() {
        int countLocalAccess = 0;
        int countForeignAccess = 0;

        for (Pedido pedido : pedidos) {
            countLocalAccess++; // Acceso a atributo de la misma clase
            if (!pedido.entregado) {
                System.out.println("Procesando pedido de " + pedido.nombre + " en mesa " + pedido.mesa);
                for (String item : pedido.items) {
                    System.out.println("  Preparando: " + item);
                    countLocalAccess++; // Acceso local a items
                    if (item.equals("Pizza")) {
                        System.out.println("    Horneando pizza...");
                        for (int i = 0; i < 3; i++) {
                            System.out.println("      Minuto " + (i + 1));
                        }
                    } else if (item.equals("Ensalada")) {
                        System.out.println("    Cortando ingredientes...");
                        for (String ingrediente : Arrays.asList("Lechuga", "Tomate", "Zanahoria")) {
                            System.out.println("      Agregando " + ingrediente);
                            countForeignAccess++; // Acceso a lista externa
                        }
                    }
                }
                pedido.entregado = true;
                countLocalAccess++; // Modificación de atributo local
                System.out.println("Pedido de " + pedido.nombre + " entregado.");
            }
        }
        
        double LAA = (double) countLocalAccess / (countLocalAccess + countForeignAccess);
        System.out.println("Locality of Attribute Access (LAA): " + LAA);
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante(10);
        restaurante.agregarPedido("Carlos", Arrays.asList("Pizza", "Ensalada"), 5);
        restaurante.agregarPedido("Ana", Arrays.asList("Hamburguesa"), 2);
        restaurante.procesarPedidos();
    }
}
