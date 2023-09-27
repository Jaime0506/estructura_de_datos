import java.util.ArrayList;
import java.util.Iterator; 
import javax.swing.JOptionPane;

public class ListaCantantesFamosos {
	public ArrayList<CantanteFamoso> listaCantantesFamosos = new ArrayList<CantanteFamoso>();
	
	public void agregarCantanteFamoso(String nombre, String discoMasVentas, int cantidadVentas) { 
		CantanteFamoso cantante = new CantanteFamoso(nombre, discoMasVentas, cantidadVentas);
		listaCantantesFamosos.add(cantante);
	}
	
	public void mostratCantante() {
		for (Iterator<CantanteFamoso> iterator = listaCantantesFamosos.iterator(); iterator.hasNext();) {
			CantanteFamoso cantanteFamoso = (CantanteFamoso) iterator.next();
			
			System.out.println(cantanteFamoso.getNombre() + ": " + cantanteFamoso.getDisco()); 
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
			String message = "El cantante " + listaCantantesFamosos.get(id).getNombre() + " fue eliminado correctamente"; 
			listaCantantesFamosos.remove(id);
			
			JOptionPane.showMessageDialog(null, message);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "El cantante a eliminar no se encontro");
		} 
	}
}
