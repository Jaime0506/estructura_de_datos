import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Main {
	static Grafo grafo = new Grafo(); 
	
	static void agregarDatos() { 
        grafo.agregarVertice("UMB");
        grafo.agregarVertice("Simon Bolivar");
        grafo.agregarVertice("Nacional");
        grafo.agregarVertice("93");
        grafo.agregarVertice("Usaquen"); 
        grafo.agregarVertice("Tunal");
        grafo.agregarVertice("El Virrey");
        grafo.agregarVertice("Independencia");
        grafo.agregarVertice("Regional la Florida");
        grafo.agregarVertice("San jose de bavaria");
        
        // UMB CON TODOS
        grafo.agregarArista("UMB", "Simon Bolivar", 19.6);
        grafo.agregarArista("UMB", "Nacional", 7.2);
        grafo.agregarArista("UMB", "93", 5.5);
        grafo.agregarArista("UMB", "Usaquen", 7);
        grafo.agregarArista("UMB", "Tunal", 19.6);
        grafo.agregarArista("UMB", "El Virrey", 5.2);
        grafo.agregarArista("UMB", "Independencia", 9.9);
        grafo.agregarArista("UMB", "Regional la Florida", 19.9);
        grafo.agregarArista("UMB", "San jose de bavaria", 16.7);
        
        // Simon Bolivar con todos
        grafo.agregarArista("Simon Bolivar", "Nacional", 7.9);
        grafo.agregarArista("Simon Bolivar", "93", 7.8);
        grafo.agregarArista("Simon Bolivar", "Usaquen", 10.2);
        grafo.agregarArista("Simon Bolivar", "Tunal", 14);
        grafo.agregarArista("Simon Bolivar", "El Virrey", 7.7);
        grafo.agregarArista("Simon Bolivar", "Independencia", 7.1);
        grafo.agregarArista("Simon Bolivar", "Regional la Florida", 15.6);
        grafo.agregarArista("Simon Bolivar", "San jose de bavaria", 12.1);
        
        // Nacional
        grafo.agregarArista("Nacional", "93", 8);
        grafo.agregarArista("Nacional", "Usaquen", 9.6);
        grafo.agregarArista("Nacional", "Tunal", 15.2);
        grafo.agregarArista("Nacional", "El Virrey", 6.1);
        grafo.agregarArista("Nacional", "Independencia", 1.9);
        grafo.agregarArista("Nacional", "Regional la Florida", 19.7);
        grafo.agregarArista("Nacional", "San jose de bavaria", 19); 
        
        // 93
        grafo.agregarArista("93", "Usaquen", 4);
        grafo.agregarArista("93", "Tunal", 20);
        grafo.agregarArista("93", "El Virrey", 1);
        grafo.agregarArista("93", "Independencia", 11.1);
        grafo.agregarArista("93", "Regional la Florida", 14.7);
        grafo.agregarArista("93", "San jose de bavaria", 12.3);
       
        // Usaquen
        grafo.agregarArista("Usaquen", "Tunal", 24.8);
        grafo.agregarArista("Usaquen", "El Virrey", 5.2);
        grafo.agregarArista("Usaquen", "Independencia", 12.3);
        grafo.agregarArista("Usaquen", "Regional la Florida", 19.6);
        grafo.agregarArista("Usaquen", "San jose de bavaria", 9.7);
       
        // Tunal
        grafo.agregarArista("Tunal", "El Virrey", 16.6);
        grafo.agregarArista("Tunal", "Independencia", 13.4);
        grafo.agregarArista("Tunal", "Regional la Florida", 27.6);
        grafo.agregarArista("Tunal", "San jose de bavaria", 26);
        
        // Virrey
        grafo.agregarArista("El Virrey", "Independencia", 7.7);
        grafo.agregarArista("El Virrey", "Regional la Florida", 14.2);
        grafo.agregarArista("El Virrey", "San jose de bavaria", 12.7);
        
        // Independencia
        grafo.agregarArista("Independencia", "Regional la Florida", 23.1);
        grafo.agregarArista("Independencia", "San jose de bavaria", 18.6);
        
        // Regional la Florida
        grafo.agregarArista("Regional la Florida", "San jose de bavaria", 10.8); 
	}

    public static void main(String[] args) {
    	agregarDatos();
    	
    	JFrame frame = new JFrame("Grafo Visual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1080);

        
        // Funcionalidades necesarias
        
//        4.	Elabore la matriz correspondiente para representar los nodos y distancias del tema seleccionado y muéstrela por pantalla. ✅
//
//        5.	Represente el Grafo de manera gráfica, (Dibújelo en la pantalla)✅
//
//        6.	Busque en la guía y en libro del curso e implemente en el lenguaje de programación Java, el código del algoritmo Dijkstra para hallar la ruta más corta. Plantee un ejemplo dentro de su código de mínimo 10 nodos y 30 aristas.
//
//        7.	Busque en la guía y en el libro del e implemente en el lenguaje de programación Java, el código de los algoritmos de Prim, Floyd Warshall. La implementación debe ser sobre el mismo proyecto(Sesión 1) que ha venido trabajando con grafos. 

        grafo.mostrarNombresVertices();
        grafo.mostrarMatrizAdyacencia(); 
        grafo.mostrarMatrizAdyacenciaConPeso();

        System.out.println("");
        System.out.println("_______________________________");
        System.out.println("Algoritmo de dijkstra");
        System.out.println("-------------------------------");
        System.out.println();

        grafo.mostrarDijkstra("93");
       

        GrafoCanvas canvas = new GrafoCanvas(grafo);
        frame.add(canvas);
        frame.setVisible(true);
    }
}