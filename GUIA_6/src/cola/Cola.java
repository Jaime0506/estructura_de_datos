package cola;

import java.util.LinkedList;

public class Cola<T> {
    private LinkedList<T> elementos;

    public Cola() {
        elementos = new LinkedList<>();
    }

    // Agregar un elemento al final de la cola
    public void encolar(T elemento) {
        elementos.addLast(elemento);
    }

    // Eliminar y devolver el elemento al frente de la cola
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.removeFirst();
    }

    // Devolver el elemento al frente de la cola sin eliminarlo
    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.getFirst();
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    // Devolver el tamaño de la cola
    public int tamano() {
        return elementos.size();
    }

    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);

        System.out.println("El frente de la cola es: " + cola.frente());

        System.out.print("Desencolando elementos: ");
        while (!cola.estaVacia()) {
            System.out.print(cola.desencolar() + " ");
        }
        System.out.println();
    }
}
