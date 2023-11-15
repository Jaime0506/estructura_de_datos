package Exercise_2;

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
		PriorityQueue<String> colaPrioridad = new PriorityQueue<>(Comparator.comparing(distancias::get));

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

	public void mostrarCaminoMasCorto(String inicio, String ultimo) {
		List<String> caminoMasCorto = dijkstra(inicio, ultimo);
		System.out.println("");
		System.out.println("Camino más corto desde " + inicio + " hasta " + ultimo + ": " + caminoMasCorto);
	}

	public double[][] floydWarshall() {
        int n = vertices.size();
        double[][] distancias = new double[n][n];
        padres = new int[n][n]; // Inicializamos la matriz de padres
        distanciasMaximas = new double[n][n];

        // Inicialización de matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = Double.POSITIVE_INFINITY;
                padres[i][j] = -1;
                distanciasMaximas[i][j] = Double.NEGATIVE_INFINITY;
            }
            distancias[i][i] = 0.0;
        }

        // Establecer distancias directas según las aristas existentes
        for (Map.Entry<String, Map<String, Double>> entry : vertices.entrySet()) {
            String u = entry.getKey();
            int i = Integer.parseInt(u) - 1;
            for (Map.Entry<String, Double> vecino : entry.getValue().entrySet()) {
                String v = vecino.getKey();
                int j = Integer.parseInt(v) - 1;
                distancias[i][j] = vecino.getValue();
                padres[i][j] = i;
                distanciasMaximas[i][j] = vecino.getValue();
            }
        }

        // Bucle principal del algoritmo
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        padres[i][j] = padres[k][j];
                    }
                    if (distanciasMaximas[i][k] * distanciasMaximas[k][j] > distanciasMaximas[i][j]) {
                        distanciasMaximas[i][j] = distanciasMaximas[i][k] * distanciasMaximas[k][j];
                    }
                }
            }
        }

        // Verificar ciclos negativos
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        System.out.println("Ciclo negativo detectado en el nodo " + (k + 1));
                    }
                }
            }
        }

        return distancias;
    }

    public void imprimirCamino(int i, int j) {
        if (padres[i][j] == -1) {
            System.out.println("No hay camino desde " + (i + 1) + " hasta " + (j + 1));
        } else {
            imprimirCamino(i, padres[i][j]);
            System.out.print((j + 1) + " ");
        }
    }

    public double obtenerCostoMaximo(int i, int j) {
        if (distanciasMaximas[i][j] == Double.NEGATIVE_INFINITY) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return distanciasMaximas[i][j];
        }
    }

	public void mostrarCaminoMasLargo(String inicio, String destino) {

		double[][] distancias = floydWarshall();

        // Indice correspondiente al nodo de destino

       imprimirCamino(0, 8);

        double costoMaximo = obtenerCostoMaximo(0, 8);
        if (costoMaximo > Double.NEGATIVE_INFINITY) {
            System.out.println("El costo máximo del camino es: " + costoMaximo);
        } else {
            System.out.println("No hay camino desde " + (inicio) + " hasta " + (destino));
        }
	}
}
