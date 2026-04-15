import java.util.*;

public class PuertoDataBay {
    private Contenedor[] manifiesto; // Módulo 1 [cite: 11]
    private Contenedor[][] patio;     // Módulo 2 [cite: 17]
    private Queue<Contenedor> inspeccion; // Módulo 3 [cite: 23]
    private Stack<Contenedor> buque;      // Módulo 4 [cite: 26]

    public PuertoDataBay() {
        patio = new Contenedor[5][5]; 
        inspeccion = new LinkedList<>(); 
        buque = new Stack<>(); 
    }

    // Módulo 1: Registro de Manifiesto [cite: 11]
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
        System.out.println("\nPeso total entrante: " + pesoTotal + "t"); [cite: 15]
    }

    // IMPORTANTE: Este método DEBE estar para que Main no de error
    public Contenedor[] getManifiesto() {
        return manifiesto;
    }

    // Módulo 2: Ubicación en Matriz [cite: 17]
    public void ubicarEnPatio(Contenedor c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) { // Primera celda null [cite: 20]
                    patio[i][j] = c;
                    System.out.println("Ubicado en Patio [" + i + "][" + j + "]");
                    return;
                }
            }
        }
        System.out.println("ALERTA: ¡Puerto Saturado!"); [cite: 21]
    }

    // Módulo 3: Inspección FIFO [cite: 23]
    public void gestionarInspeccion(Contenedor c) {
        if (c.getPrioridad() >= 4) { 
            inspeccion.add(c);
            System.out.println("En cola de Rayos X: " + c.getId());
        }
    }

    // Módulo 4: Estiba LIFO con Bono de Estabilidad [cite: 26, 51]
    public void cargarBuque(Contenedor c) {
        if (buque.isEmpty() || c.getPeso() <= buque.peek().getPeso()) {
            buque.push(c);
            System.out.println("Cargado al buque: " + c.getId());
        } else {
            System.out.println("RECHAZADO: Inestabilidad por peso (" + c.getPeso() + "t)");
        }
    }

    // Operación Crítica: Pila Auxiliar [cite: 31]
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