import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PuertoDataBay puerto = new PuertoDataBay();

        System.out.print("Cantidad de contenedores: ");
        int n = sc.nextInt();
        
        // CORRECCIÓN LÍNEA 13: Enviamos el scanner como segundo parámetro
        puerto.registrarCamion(n, sc);

        // CORRECCIÓN LÍNEA 17: Usamos el getter
        Contenedor[] carga = puerto.getManifiesto();

        for (Contenedor c : carga) {
            if (c != null) {
                puerto.ubicarEnPatio(c);
                puerto.gestionarInspeccion(c);
                puerto.cargarBuque(c);
            }
        }

        puerto.retirarDañado();
        sc.close();
    }
}