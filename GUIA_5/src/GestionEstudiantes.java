import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionEstudiantes {
	public HashMap<Integer, Estudiante> estudiantes = new HashMap<Integer, Estudiante>();

	public void addEstudiante(int id, String nombre, String apellido, String direccion, String telefono, String carrera,
			JFrame frame, DefaultTableModel table) {
		if (existeEstudiante(id)) {
			JOptionPane.showMessageDialog(frame, "El estudiante con ese ID ya existe", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			estudiantes.put(id, new Estudiante(nombre, apellido, direccion, telefono, carrera));
			rellenarTabla(table);
		}
	}

	public void deleteEstudiante(int id, JFrame frame, DefaultTableModel table) {
		if (existeEstudiante(id)) { 
			String message = "El estudiante " + estudiantes.get(id).obtenerNombre() + " de ID: " + id + "Fue eliminado exitosamente";
			estudiantes.remove(id);

			JOptionPane.showMessageDialog(frame, message); 
			rellenarTabla(table);
		} else {
			JOptionPane.showMessageDialog(frame, "El estudiante con ese ID no existe", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cambiarDatos(int id, String option, String valor, JFrame frame, DefaultTableModel table) {
		if (existeEstudiante(id)) {

			if (option == "Nombre") {
				estudiantes.get(id).cambiarNombre(valor, frame);
			}

			if (option == "Apellido") {
				estudiantes.get(id).cambiarApellido(valor, frame);
			}

			if (option == "Direccion") {
				estudiantes.get(id).cambiarDireccion(valor, frame);
			}

			if (option == "Telefono") {
				estudiantes.get(id).cambiarTelefono(valor, frame);
			}

			if (option == "Carrera") {
				estudiantes.get(id).cambiarCarrera(valor, frame);
			}
			
			rellenarTabla(table);

		} else {
			JOptionPane.showMessageDialog(frame, "El estudiante con ese ID no existe", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void rellenarTabla(DefaultTableModel table) {
		// Limpiamos la tabla siempre al inicio
		table.setRowCount(0);

		table.setRowCount(estudiantes.size());
		int rows = 0;

		for (Entry<Integer, Estudiante> entry : estudiantes.entrySet()) { 
			int key = entry.getKey();

			for (int columns = 0; columns < 6; columns++) {

				//ID
				if (columns == 0) {
					table.setValueAt(key, rows, columns);
				}

				// Nombre
				if (columns == 1) {
					table.setValueAt(estudiantes.get(key).obtenerNombre(), rows, columns);
				}

				// Apellida
				if (columns == 2) {
					table.setValueAt(estudiantes.get(key).obtenerApellido(), rows, columns);
				}

				// Direccion
				if (columns == 3) {
					table.setValueAt(estudiantes.get(key).obtenerDireccion(), rows, columns);
				}
				
				// Telefono
				if (columns == 4) {
					table.setValueAt(estudiantes.get(key).obtenerTelefono(), rows, columns);
				}

				// Carrera
				if (columns == 5) {
					table.setValueAt(estudiantes.get(key).obtenerCarrera(), rows, columns);
				}
			} 
			rows++;
		}
	}

	public boolean existeEstudiante(int id) {
		boolean existe = estudiantes.containsKey(id);

		return existe;
	}
}
