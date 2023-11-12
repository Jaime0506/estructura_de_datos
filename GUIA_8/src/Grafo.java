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
}