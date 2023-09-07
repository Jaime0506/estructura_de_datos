import javax.swing.JOptionPane;

public class BinarySearch {
	
	public String binarySearch(int[] array, int numberFind) { 
		long timeInit = System.nanoTime();
		long timeEnd = 5;
		
		int center = 0;
		int sup = array.length - 1;
		int inf = 0;

		boolean result = false; 
		
		while(inf <= sup) { 
			center = (sup + inf)/2; 
			if (array[center] == numberFind) {
				result = true; 
				break;

			} else if (array[center]>numberFind) { 
				sup = center - 1;
			} else { 
				inf = center + 1;
			} 
		}
		
		if (result) {
			timeEnd = System.nanoTime() - timeInit;
			JOptionPane.showMessageDialog(null, "El elemento fue encontrado en la posicion: " + (center + 1)); 
		} else {
			JOptionPane.showMessageDialog(null, "El elemento no se encontro :(", "No se encontro",  JOptionPane.ERROR_MESSAGE); 
		}
		
		String message = "La operacion duro " + timeEnd + " ns";
		
		return message;
	} 
}
