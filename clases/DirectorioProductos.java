package clases;
import java.util.HashMap;


public class DirectorioProductos {
    public static void main(String[] args) {
        HashMap<Integer, String> inventario = new HashMap<>();

        // Registrar productos
        inventario.put(101, "Laptop");
        inventario.put(102, "Mouse");
        inventario.put(103, "Teclado");

        // Verificar existencia
        System.out.println("¿Existe la llave 102?: " + inventario.containsKey(102));

        // Intento de insertar llave duplicada (esto sobrescribe el valor)
        inventario.put(101, "Monitor");

        // Recorrer el mapa
        for (Integer codigo : inventario.keySet()) {
            System.out.println("Código: " + codigo + " -> Producto: " + inventario.get(codigo));
        }
    }
}