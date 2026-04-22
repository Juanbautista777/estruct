package clases;
import java.util.LinkedList;


public class HistorialNavegacion {
    public static void main(String[] args) {
        LinkedList<String> historial = new LinkedList<>();

        // Añadir URLs
        historial.add("google.com");
        historial.add("github.com");
        historial.add("stackoverflow.com");

        // Mostrar página actual
        System.out.println("Página actual: " + historial.getLast());

        // Función "Atrás"
        historial.removeLast();
        System.out.println("Nueva página actual: " + historial.getLast());

        // Imprimir historial restante
        System.out.println("Historial restante:");
        for (String url : historial) {
            System.out.println("- " + url);
        }
    }
}