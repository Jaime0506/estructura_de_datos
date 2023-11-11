import java.util.*;

class Grafo {
    private Map<String, Map<String, Double>> vertices;

    public Grafo() {
        vertices = new HashMap<>();
    }

    public void agregarVertice(String nombre) {
        vertices.put(nombre, new HashMap<>());
    }

    public void agregarArista(String origen, String destino, double peso) {
        vertices.get(origen).put(destino, peso);
        vertices.get(destino).put(origen, peso); // Para un grafo no dirigido
    }

    public Map<String, Double> obtenerVecinos(String nombre) {
        return vertices.get(nombre);
    }

    public Set<String> obtenerVertices() {
        return vertices.keySet();
    }
    
    public Double obtenerPesoArista(String origen, String destino) {
        return vertices.get(origen).get(destino);
    }
}