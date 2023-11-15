package Exercise_1;
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


        grafo.mostrarNombresVertices();
        grafo.mostrarMatrizAdyacencia(); 

		grafo.mostrarNombresVertices();
        grafo.mostrarMatrizAdyacenciaConPeso();


        GrafoCanvas canvas = new GrafoCanvas(grafo);
        frame.add(canvas);
        frame.setVisible(true);
        
        grafo.mostrarDijkstra("93");
        grafo.mostrarPrim();
        grafo.floydWarshall(); 
    }
}