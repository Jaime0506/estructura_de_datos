import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Estudiante {
	private String nombre = "";
	private String apellido = "";
	private String direccion = "";
	private String telefono = "";
	private String carrera = "";
	
	public Estudiante(String nombre, String apellido, String direccion, String telefono, String carrera) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.carrera = carrera;
	}
	
	public void cambiarNombre(String nuevoNombre, JFrame frame) {
		if (nuevoNombre.length() > 0) { 
			nombre = nuevoNombre;
		} else {
			JOptionPane.showMessageDialog(frame, "El nuevo nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cambiarApellido(String nuevoApellido, JFrame frame) {
		if (nuevoApellido.length() > 0) { 
			apellido = nuevoApellido;
		} else {
			JOptionPane.showMessageDialog(frame, "El nuevo apellido no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cambiarDireccion(String nuevaDireccion, JFrame frame) {
		if (nuevaDireccion.length() > 0) { 
			direccion = nuevaDireccion;
		} else {
			JOptionPane.showMessageDialog(frame, "La nueva direccion no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cambiarTelefono(String nuevoTelefono, JFrame frame) {
		if (nuevoTelefono.length() > 0) {
			telefono = nuevoTelefono;
		} else {
			JOptionPane.showMessageDialog(frame, "El telefono no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cambiarCarrera(String nuevaCarrera, JFrame frame) {
		if (nuevaCarrera.length() > 0) {
			carrera = nuevaCarrera;
		} else {
			JOptionPane.showMessageDialog(frame, "La carrera no puede estar vacia", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String obtenerNombre() {
		return nombre; 
	}
	
	public String obtenerApellido() {
		return apellido; 
	}
	
	public String obtenerDireccion() {
		return direccion; 
	}
	
	public String obtenerTelefono() {
		return telefono; 
	}
	
	public String obtenerCarrera() {
		return carrera; 
	} 
}
