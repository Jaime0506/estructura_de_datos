package Exercise_2;

import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Grafo {
	private Map<String, Map<String, Double>> vertices;
	private double[][] distanciasMaximas;
	private int[][] padres;

	public Grafo() {
		vertices = new HashMap<>();
	}

	public void agregarVertice(String nombre) {
		vertices.put(nombre, new HashMap<>());
	}

	public void agregarArista(String origen, String destino, double peso) {
		vertices.get(origen).put(destino, peso);
	}

	public Map<String, Double> obtenerVecinos(String nombre) {
		return vertices.get(nombre);
	}

	public Set<String> obtenerVertices() {
		return vertices.keySet();
	}

	public void mostrarListaAdyacencia() {

		System.out.println("-----------------------------");
		System.out.println("Lista de Adyacencia con pesos");
		System.out.println("_____________________________");
		System.out.println();

		for (String vertice : vertices.keySet()) {
			System.out.print(vertice + " -> ");
			Map<String, Double> vecinos = vertices.get(vertice);
			for (Map.Entry<String, Double> vecino : vecinos.entrySet()) {
				System.out.print("(" + vecino.getKey() + ", " + vecino.getValue() + ") ");
			}
			System.out.println();
		}
	}

	private List<String> dijkstra(String inicio, String destino) {
        Map<String, Double> distancias = new HashMap<>();
        Map<String, String> padres = new HashMap<>();
        PriorityQueue<Map.Entry<String, Double>> colaPrioridad = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

        for (String vertice : vertices.keySet()) {
            distancias.put(vertice, Double.MAX_VALUE);
            padres.put(vertice, null);
            colaPrioridad.add(new AbstractMap.SimpleEntry<>(vertice, Double.MAX_VALUE));
        }

        distancias.put(inicio, 0.0);
        colaPrioridad.add(new AbstractMap.SimpleEntry<>(inicio, 0.0));

        while (!colaPrioridad.isEmpty()) {
            Map.Entry<String, Double> nodoActual = colaPrioridad.poll();
            String u = nodoActual.getKey();

            for (Map.Entry<String, Double> vecino : vertices.get(u).entrySet()) {
                String v = vecino.getKey();
                double pesoUV = vecino.getValue();
                double nuevaDistancia = distancias.get(u) + pesoUV;

                if (nuevaDistancia < distancias.get(v)) {
                    distancias.put(v, nuevaDistancia);
                    padres.put(v, u);
                    colaPrioridad.remove(new AbstractMap.SimpleEntry<>(v, distancias.get(v)));
                    colaPrioridad.add(new AbstractMap.SimpleEntry<>(v, distancias.get(v)));
                }
            }
        }

        // Reconstruir el camino desde el destino hasta el inicio
        List<String> camino = new ArrayList<>();
        String actual = destino;
        double costoTotal = 0.0;

        while (actual != null) {
            camino.add(actual);
            if (padres.get(actual) != null) {
                costoTotal += vertices.get(padres.get(actual)).get(actual);
            }
            actual = padres.get(actual);
        }
        Collections.reverse(camino);

        System.out.println();
        System.out.println("Costo total del recorrido: " + costoTotal);

        return camino;
    }

	public void mostrarCaminoMasCorto(String inicio, String ultimo) {
		List<String> caminoMasCorto = dijkstra(inicio, ultimo); 
		System.out.println("Camino más corto desde " + inicio + " hasta " + ultimo + ": " + caminoMasCorto);
	} 

	public List<String> caminoMasLargo(String inicio, String destino) {
		Map<String, Double> distancias = new HashMap<>();
		Map<String, String> padres = new HashMap<>();
		PriorityQueue<String> colaPrioridad = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(distancias::get)));
		

		for (String vertice : vertices.keySet()) {
			distancias.put(vertice, Double.MAX_VALUE);
			padres.put(vertice, null);
			colaPrioridad.add(vertice);
		}

		distancias.put(inicio, 0.0);

		while (!colaPrioridad.isEmpty()) {
			String u = colaPrioridad.poll();

			for (Map.Entry<String, Double> vecino : vertices.get(u).entrySet()) {
				String v = vecino.getKey();
				double pesoUV = vecino.getValue();
				double nuevaDistancia = distancias.get(u) + pesoUV;

				if (nuevaDistancia < distancias.get(v)) {
					distancias.put(v, nuevaDistancia);
					padres.put(v, u);
					colaPrioridad.remove(v);
					colaPrioridad.add(v);
				}
			}
		}

		// Reconstruir el camino desde el destino hasta el inicio
		List<String> camino = new ArrayList<>();
		String actual = destino;
		while (actual != null) {
			camino.add(actual);
			actual = padres.get(actual);
		}
		Collections.reverse(camino);

		return camino;
	}
	
	public void mostrarCaminoMasLargo() {
		String inicio = "1";
        String destino = "9"; 
        

        List<String> caminoMasLargo = caminoMasLargo(inicio, destino);
        System.out.println();
        System.out.println("Camino más largo desde " + inicio + " hasta " + destino + ": " + caminoMasLargo);
	}
	
	public void floydWarshall() {
        int numVertices = vertices.size();
        double[][] distancias = new double[numVertices][numVertices];

        // Inicializar la matriz de distancias
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(distancias[i], Double.POSITIVE_INFINITY);
            distancias[i][i] = 0;
        }

        // Llenar la matriz con las distancias conocidas
        for (Map.Entry<String, Map<String, Double>> entrada : vertices.entrySet()) {
            String origen = entrada.getKey();
            int indiceOrigen = obtenerIndiceVertice(origen);

            for (Map.Entry<String, Double> vecino : entrada.getValue().entrySet()) {
                String destino = vecino.getKey();
                double peso = vecino.getValue();
                int indiceDestino = obtenerIndiceVertice(destino);
                distancias[indiceOrigen][indiceDestino] = peso;
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("");
		System.out.println("_______________________________");
		System.out.println("Algoritmo de Floyd Warshall - Dirigido");
		System.out.println("-------------------------------");
		System.out.println();
        
        // Imprimir las distancias mínimas entre todos los pares de vértices
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%-3s", df.format(distancias[i][j]) + " | ");
            }
            System.out.println();
        }
    }
	
	private int obtenerIndiceVertice(String nombre) {
        int indice = 0;
        for (String vertice : vertices.keySet()) {
            if (vertice.equals(nombre)) {
                return indice;
            }
            indice++;
        }
        return -1; // Si no se encuentra el vértice
    }
}
