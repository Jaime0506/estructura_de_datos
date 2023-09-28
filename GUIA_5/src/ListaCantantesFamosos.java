import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaCantantesFamosos {
	public ArrayList<CantanteFamoso> listaCantantesFamosos = new ArrayList<CantanteFamoso>();
	
	public boolean verificarExisteId(int ID) {
		boolean estaVacio = true;
		
		int size = listaCantantesFamosos.size();
		
		if (ID <= size - 1) {
			// EL ID es la posicion dentro del ArrayList si las posicon es igual o menor al size significa que esta
			// seleccionando un cantante que ya deberia existir
			
			estaVacio = false;
		}
		
		return estaVacio;
		
	}

	public void agregarCantanteFamoso(String nombre, String discoMasVentas, int cantidadVentas) {
		CantanteFamoso cantante = new CantanteFamoso(nombre, discoMasVentas, cantidadVentas);
		listaCantantesFamosos.add(cantante);
	}

	private void mostratCantantes() {
		System.out.println("-------------------------------");
		System.out.println("-------Lista de cantantes------"); 
		System.out.println("-------------------------------");

		for (Iterator<CantanteFamoso> iterator = listaCantantesFamosos.iterator(); iterator.hasNext();) { 
			CantanteFamoso cantanteFamoso = (CantanteFamoso) iterator.next();
			
			System.out.println();
			System.out.println(cantanteFamoso.getNombre() + ": " + cantanteFamoso.getDisco() + " Ventas: "
					+ cantanteFamoso.getVentas());
		} 
		System.out.println("-------------------------------");
	}

	public void modificarNombre(int id, String nuevoNombre) {
		listaCantantesFamosos.get(id).setNombre(nuevoNombre);
	}

	public void modificarDisco(int id, String nuevoDisco) {
		listaCantantesFamosos.get(id).setDisco(nuevoDisco);
	}

	public void eliminarCantante(int id) {
		try {
			String message = "El cantante " + listaCantantesFamosos.get(id).getNombre()
					+ " fue eliminado correctamente";
			
			listaCantantesFamosos.remove(id); 
			JOptionPane.showMessageDialog(null, message);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "El cantante a eliminar no se encontro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	} 

	public void setValuesTable(DefaultTableModel table) {
		// PARA LIMPIAR ANTES TODOS LOS VALORES DE LA LISTA 
		table.setRowCount(0);

		table.setRowCount(listaCantantesFamosos.size());

		for (int rows = 0; rows < listaCantantesFamosos.size(); rows++) {
			for (int columns = 0; columns < 4; columns++) {

				if (columns == 0) {
					table.setValueAt(rows, rows, columns);
				}

				if (columns == 1) {
					table.setValueAt(listaCantantesFamosos.get(rows).getNombre(), rows, columns);
				}

				if (columns == 2) {
					table.setValueAt(listaCantantesFamosos.get(rows).getDisco(), rows, columns);
				}

				if (columns == 3) {
					table.setValueAt(listaCantantesFamosos.get(rows).getVentas(), rows, columns);
				}
			}
		}
		
		mostratCantantes();
	} 
	
	public void ordenarDeMayorAMenor() {
		ArrayList<CantanteFamoso> listaOrdenada = new ArrayList<CantanteFamoso>(listaCantantesFamosos);
		
		selectionSort(listaOrdenada); 
		
		System.out.println("-----------------------------------");
		System.out.println("----Lista de cantantes Ordenada----"); 
		System.out.println("-----------------------------------");
		
		for (Iterator<CantanteFamoso> iterator = listaOrdenada.iterator(); iterator.hasNext();) {
			CantanteFamoso cantanteFamoso = (CantanteFamoso) iterator.next();
			
			System.out.println();
			System.out.println(cantanteFamoso.getNombre() + ": " + cantanteFamoso.getDisco() + " Ventas: "
					+ cantanteFamoso.getVentas());
		} 
		System.out.println("-----------------------------------"); 
	}
	
	private void selectionSort(ArrayList<CantanteFamoso> lista) {
		int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getVentas() > lista.get(maxIndex).getVentas()) {
                    maxIndex = j;
                }
            }

            // Intercambiar los elementos
            CantanteFamoso temp = lista.get(maxIndex);
            lista.set(maxIndex, lista.get(i));
            lista.set(i, temp);
        }
	}
}
