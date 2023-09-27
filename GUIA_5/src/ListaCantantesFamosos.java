import java.util.ArrayList;
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

	public void mostratCantantes() {
		for (Iterator<CantanteFamoso> iterator = listaCantantesFamosos.iterator(); iterator.hasNext();) {
			CantanteFamoso cantanteFamoso = (CantanteFamoso) iterator.next();
			
			System.out.println();
			System.out.println(cantanteFamoso.getNombre() + ": " + cantanteFamoso.getDisco() + " Ventas: "
					+ cantanteFamoso.getVentas());
		}
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
			JOptionPane.showMessageDialog(null, "El cantante a eliminar no se encontro");
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
	} 
}
