package tareas;
import java.util.*;

public class PuertoDataBay {
    private Contenedor[] manifiesto;
    private Contenedor[][] patio;
    private Queue<Contenedor> inspeccion;
    private Stack<Contenedor> buque;

    public PuertoDataBay() {
        patio = new Contenedor[5][5];
        inspeccion = new LinkedList<>();
        buque = new Stack<>();
    }

    public void registrarCamion(int n, Scanner sc) {
        manifiesto = new Contenedor[n];
        double pesoTotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nRegistro Contenedor " + (i + 1) + ":");
            System.out.print("ID: "); String id = sc.next();
            System.out.print("Peso: "); double peso = sc.nextDouble();
            System.out.print("Prioridad: "); int prio = sc.nextInt();
            
            manifiesto[i] = new Contenedor(id, peso, prio);
            pesoTotal += peso;
        }
        System.out.println("\nPeso total entrante: " + pesoTotal + "t");
    }

    public Contenedor[] getManifiesto() {
        return manifiesto;
    }

    public void ubicarEnPatio(Contenedor c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    System.out.println("Ubicado en Patio [" + i + "][" + j + "]");
                    return;
                }
            }
        }
        System.out.println("ALERTA: Puerto Saturado");
    }

    public void gestionarInspeccion(Contenedor c) {
        if (c.getPrioridad() >= 4) {
            inspeccion.add(c);
            System.out.println("En cola de Rayos X: " + c.getId());
        }
    }

    public void cargarBuque(Contenedor c) {
        if (buque.isEmpty() || c.getPeso() <= buque.peek().getPeso()) {
            buque.push(c);
            System.out.println("Cargado al buque: " + c.getId());
        } else {
            System.out.println("RECHAZADO: Inestabilidad por peso (" + c.getPeso() + "t)");
        }
    }

    public void retirarDañado() {
        if (buque.isEmpty()) return;
        Stack<Contenedor> aux = new Stack<>();
        while (buque.size() > 1) {
            aux.push(buque.pop());
        }
        System.out.println("\nRetirando dañado de la base: " + buque.pop().getId());
        while (!aux.isEmpty()) {
            buque.push(aux.pop());
        }
    }
}