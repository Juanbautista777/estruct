package tareas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PuertoDataBay puerto = new PuertoDataBay();

        System.out.print("Cantidad de contenedores del camión: ");
        int n = sc.nextInt();
        
        puerto.registrarCamion(n, sc);

        Contenedor[] carga = puerto.getManifiesto();
        if (carga != null) {
            for (Contenedor c : carga) {
                if (c != null) {
                    puerto.ubicarEnPatio(c);
                    puerto.gestionarInspeccion(c);
                    puerto.cargarBuque(c);
                }
            }
        }

        puerto.retirarDañado();
        
        System.out.println("\nProceso finalizado.");
        sc.close();
    }
}