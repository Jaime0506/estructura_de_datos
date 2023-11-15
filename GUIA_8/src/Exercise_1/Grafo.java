package Exercise_1;
import java.text.DecimalFormat;
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

	public String[] obtenerNombreVertices() {
		String nombres[] = new String[vertices.size()];

		int count = 0;

		for (String nombre : obtenerVertices()) {
			nombres[count] = nombre;
			count++;
		}

		return nombres;
	}

	public void mostrarNombresVertices() {
		String nombres[] = obtenerNombreVertices();

		System.out.print("| UMB" + " | ");

		for (String nombre : nombres) {
			if (!nombre.equals("UMB")) {
				System.out.print(nombre + " | ");
			}
		}

		System.out.println();
	}

	public Double obtenerPesoArista(String origen, String destino) {
		return vertices.get(origen).get(destino);
	}

	private int[][] matrizAdyacencia() {
		List<String> verticesList = new ArrayList<>(obtenerVertices());
		int n = verticesList.size();
		int[][] matriz = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String vertice1 = verticesList.get(i);
				String vertice2 = verticesList.get(j);

				if (vertice1.equals(vertice2)) {
					matriz[i][j] = 0; // No hay conexión consigo mismo
				} else {
					Double peso = obtenerPesoArista(vertice1, vertice2);
					matriz[i][j] = (peso != null) ? (int) 1 : 0;
				}
			}
		}
		return matriz;
	}

	public void mostrarMatrizAdyacencia() {
		int[][] matriz = matrizAdyacencia();

		System.out.println("____________________________________________");
		System.out.println("Matriz adyacencia");
		System.out.println("--------------------------------------------");
		// Mostrar la matriz por consola
		for (int[] fila : matriz) {
			for (int value : fila) {
				System.out.printf("%3d", value);
			}

			System.out.println();
		}
	}

	private int[][] matrizAdyacenciaConPesos() {
		List<String> verticesList = new ArrayList<>(obtenerVertices());
		int n = verticesList.size();
		int[][] matriz = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String vertice1 = verticesList.get(i);
				String vertice2 = verticesList.get(j);

				if (vertice1.equals(vertice2)) {
					matriz[i][j] = 0; // No hay conexión consigo mismo
				} else {
					Double peso = obtenerPesoArista(vertice1, vertice2);
					matriz[i][j] = (peso != null) ? (int) Math.round(peso) : 0;
				}
			}
		}
		return matriz;
	}

	public void mostrarMatrizAdyacenciaConPeso() {
		int[][] matriz = matrizAdyacenciaConPesos();

		System.out.println("____________________________________________");
		System.out.println("Matriz adyacencia con pesos");
		System.out.println("--------------------------------------------");
		// Mostrar la matriz por consola
		for (int[] fila : matriz) {
			for (int value : fila) {
				System.out.printf("%3d", value);
			}

			System.out.println();
		}
	}

	// Resto de la implementación del Grafo

	public Map<String, Map<String, Object>> dijkstra(String origen) {
		Map<String, Double> distancias = new HashMap<>();
		Map<String, String> padres = new HashMap<>();
		Set<String> visitados = new HashSet<>();
		PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparing(distancias::get));

		for (String vertice : vertices.keySet()) {
			distancias.put(vertice, Double.MAX_VALUE);
		}

		distancias.put(origen, 0.0);
		cola.add(origen);

		while (!cola.isEmpty()) {
			String actual = cola.poll();
			if (visitados.contains(actual)) {
				continue;
			}
			visitados.add(actual);

			for (Map.Entry<String, Double> vecino : vertices.get(actual).entrySet()) {
				String vecinoNombre = vecino.getKey();
				double peso = vecino.getValue();
				if (!visitados.contains(vecinoNombre) && distancias.get(actual) + peso < distancias.get(vecinoNombre)) {
					distancias.put(vecinoNombre, distancias.get(actual) + peso);
					padres.put(vecinoNombre, actual); // Almacena el padre para reconstruir el camino
					cola.add(vecinoNombre);
				}
			}
		}

		Map<String, Map<String, Object>> resultados = new HashMap<>();
		for (String destino : vertices.keySet()) {
			resultados.put(destino, new HashMap<>());
			resultados.get(destino).put("distancia", distancias.get(destino));

			List<String> camino = new ArrayList<>();
			String actual = destino;
			while (actual != null) {
				camino.add(actual);
				actual = padres.get(actual);
			}
			Collections.reverse(camino);
			resultados.get(destino).put("camino", camino);
		}

		return resultados;
	}

	public void mostrarDijkstra(String nodoOrigen) {

		System.out.println("");
		System.out.println("_______________________________");
		System.out.println("Algoritmo de dijkstra");
		System.out.println("-------------------------------");
		System.out.println();

		Map<String, Map<String, Object>> resultados = dijkstra(nodoOrigen);

		for (Map.Entry<String, Map<String, Object>> entrada : resultados.entrySet()) {
			String destino = entrada.getKey();
			double distancia = (double) entrada.getValue().get("distancia");
			List<String> camino = (List<String>) entrada.getValue().get("camino");

			System.out.println("Distancia desde " + nodoOrigen + " a " + destino + ": " + distancia);
			System.out.println("Camino: " + camino);
			System.out.println();
		}
	}

	public Map<String, Map<String, Double>> prim() {
		Map<String, Map<String, Double>> arbolExpansion = new HashMap<>();
		Set<String> visitados = new HashSet<>();
		PriorityQueue<Arista> colaAristas = new PriorityQueue<>(Comparator.comparingDouble(a -> a.peso));

		// Selecciona un nodo arbitrario como punto de inicio
		String primerVertice = vertices.keySet().iterator().next();
		visitados.add(primerVertice);

		// Agrega las aristas del nodo inicial a la cola de prioridad
		for (Map.Entry<String, Double> vecino : vertices.get(primerVertice).entrySet()) {
			colaAristas.add(new Arista(primerVertice, vecino.getKey(), vecino.getValue()));
		}

		while (!colaAristas.isEmpty()) {
			Arista aristaActual = colaAristas.poll();

			String verticeInicio = aristaActual.inicio;
			String verticeDestino = aristaActual.destino;
			double pesoArista = aristaActual.peso;

			if (!visitados.contains(verticeDestino)) {
				// Agrega la arista al árbol de expansión mínima
				arbolExpansion.computeIfAbsent(verticeInicio, k -> new HashMap<>()).put(verticeDestino, pesoArista);
				arbolExpansion.computeIfAbsent(verticeDestino, k -> new HashMap<>()).put(verticeInicio, pesoArista);

				// Marca el vértice como visitado
				visitados.add(verticeDestino);

				// Agrega las aristas del vértice recién visitado a la cola de prioridad
				for (Map.Entry<String, Double> vecino : vertices.get(verticeDestino).entrySet()) {
					colaAristas.add(new Arista(verticeDestino, vecino.getKey(), vecino.getValue()));
				}
			}
		}

		return arbolExpansion;
	}

	public void mostrarPrim() {
		Map<String, Map<String, Double>> arbolExpansion = prim();

		// Puedes imprimir o utilizar el árbol de expansión mínima obtenido
		System.out.println();
		System.out.println("____________________________");
		System.out.println("Árbol de expansión mínima:");
		System.out.println("----------------------------");
		System.out.println();

		for (Map.Entry<String, Map<String, Double>> entrada : arbolExpansion.entrySet()) {
			String verticeInicio = entrada.getKey();
			for (Map.Entry<String, Double> arista : entrada.getValue().entrySet()) {
				String verticeDestino = arista.getKey();
				double peso = arista.getValue();
				System.out.println(verticeInicio + " - " + verticeDestino + ": " + peso);
			}
		}
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
		System.out.println("Algoritmo de Floyd Warshall");
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