package Exercise_2;

import java.util.List;

import javax.swing.JFrame; 

public class Main {
static Grafo grafo = new Grafo(); 
	
	static void agregarDatos() { 
        grafo.agregarVertice("1");
        grafo.agregarVertice("2");
        grafo.agregarVertice("3");
        grafo.agregarVertice("4");
        grafo.agregarVertice("5"); 
        grafo.agregarVertice("6");
        grafo.agregarVertice("7");
        grafo.agregarVertice("8");
        grafo.agregarVertice("9"); 
        
        grafo.agregarArista("1", "2", 1);
        grafo.agregarArista("1", "3", 2);
        
        grafo.agregarArista("2", "3", 1);
        grafo.agregarArista("2", "4", 3);
        grafo.agregarArista("2", "5", 2);
        
        grafo.agregarArista("3", "4", 2);
        grafo.agregarArista("3", "5", 2);
        
        grafo.agregarArista("4", "7", 5);
        grafo.agregarArista("4", "6", 3);
        
        grafo.agregarArista("5", "4", 3);
        
        grafo.agregarArista("6", "5", 1);
        grafo.agregarArista("6", "7", 1);
        grafo.agregarArista("6", "8", 2); 

        grafo.agregarArista("7", "9", 1);
        
        
        grafo.agregarArista("8", "7", 3);
        grafo.agregarArista("8", "9", 5); 
	}

    public static void main(String[] args) {
    	agregarDatos();
    	
    	JFrame frame = new JFrame("Grafo Visual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1080);


        GrafoCanvas canvas = new GrafoCanvas(grafo);
        frame.add(canvas);
        frame.setVisible(true); 
        
        grafo.mostrarListaAdyacencia();
        grafo.mostrarCaminoMasCorto("1", "9"); 
        grafo.mostrarCaminoMasLargo(); 
        
        grafo.floydWarshall();
    }
}
