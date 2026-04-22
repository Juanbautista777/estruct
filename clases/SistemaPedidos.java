package clases;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SistemaPedidos {
    public static void main(String[] args) {
        Map<String, LinkedList<String>> pedidos = new HashMap<>();

        // Agregar cliente Ana
        LinkedList<String> productosAna = new LinkedList<>();
        productosAna.add("Camisa");
        productosAna.add("Pantalón");
        pedidos.put("Ana", productosAna);

        // Agregar cliente Luis
        LinkedList<String> productosLuis = new LinkedList<>();
        productosLuis.add("Zapatos");
        pedidos.put("Luis", productosLuis);

        // Imprimir cantidad de productos de Ana
        System.out.println("Productos de Ana: " + pedidos.get("Ana").size());

        // Agregar producto a Luis sin sobrescribir
        pedidos.get("Luis").add("Medias");

        // Mostrar estado final de los pedidos
        for (String cliente : pedidos.keySet()) {
            System.out.println("Cliente: " + cliente + " | Pedidos: " + pedidos.get(cliente));
        }
    }
}