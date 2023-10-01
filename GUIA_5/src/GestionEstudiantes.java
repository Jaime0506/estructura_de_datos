import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestionEstudiantes {
	public HashMap<Integer, Estudiante> estudiantes = new HashMap<Integer, Estudiante>();
	
	public void addEstudiante(int id, String nombre, String apellido, String direccion, String telefono, String carrera, JFrame frame) {
		if (existeEstudiante(id)) { 
			JOptionPane.showMessageDialog(frame, "El estudiante con ese ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			estudiantes.put(id, new Estudiante(nombre, apellido, direccion, telefono, carrera));
		}
	}
	
	public void deleteEstudiante(int id, JFrame frame) {
		if (existeEstudiante(id)) {
			estudiantes.remove(id);
		} else {
			JOptionPane.showMessageDialog(frame, "El estudiante con ese ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cambiarDatos(int id, String option, String valor, JFrame frame) {
		if (existeEstudiante(id)) {
			
			if (option == "nombre") {
				estudiantes.get(id).cambiarNombre(valor, frame);
			}
			
			if (option == "apellido") {
				estudiantes.get(id).cambiarApellido(valor, frame);
			}
			
			if (option == "direccion") {
				estudiantes.get(id).cambiarDireccion(valor, frame);
			}
			
			if (option == "telefono") {
				estudiantes.get(id).cambiarTelefono(valor, frame);
			}
			
			if (option == "carrera") {
				estudiantes.get(id).cambiarCarrera(valor, frame);
			}
			
		} else {
			JOptionPane.showMessageDialog(frame, "El estudiante con ese ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	private boolean existeEstudiante(int id) {
		boolean existe = estudiantes.containsKey(id);
		
		return existe;
	}
}
