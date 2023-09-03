import java.util.ArrayList; 
import javax.swing.JOptionPane;

public class Crud {
	
	ArrayList<Object> array = new ArrayList<>();
	
	public void addItems(Object data) {
		array.add(data); 
	}
	
	public void removeItem(Object id) {
		
		int lengthInit = array.size();
		String message = "";

		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).equals(id)) {
				array.remove(i);
			}
		}
		
		if (lengthInit != array.size()) {
			message = ("Se elimino correctamente el valor");
		} else {
			message = ("El elemento solicitado no existe dentro del vector");
		}
		
		System.out.println(message);
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	public void getItem(int position) { 
		if (position < array.size() - 1) { 
			System.out.println(array.get(position)); 
		} else {
			System.out.println("No existe la posicion solicitada");
		}
	}
	
	public String getItems() {
		String message = "[";
		for (int i = 0; i < array.size(); i++) {
			if (i == array.size() - 1) {
				message += array.get(i) + "";
			} else {
				message += array.get(i) + ", ";
			} 
		}
		
		message += "]";
		
		System.out.println(message);
		return message;
	}
	
	public void findItem(Object id) {
		
		String message = "";
		
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).equals(id)) {
				message += "Se encontro el objeto: " + array.get(i) + " en la posicion " + i + " del vector"; 
			}
		}
		
		if (message.length() < 5) {
			message = "No se encontro el elemento que busca";
		}
		
		System.out.println(message);
		JOptionPane.showMessageDialog(null, message);
	} 

	public static void main(String[] args) {
		Crud app = new Crud();
		
		app.addItems("Jaime Mejia");
		app.addItems(0.213);
		app.addItems(1121);
		app.addItems("TE AMO");
		
		
		app.getItem(2);
		app.getItem(4);
		app.getItem(0);
		app.getItem(5);

		System.out.println("-----------------");
		
		app.getItems();
		
		app.findItem("Jaime Meji"); 
		app.removeItem("TE AMO");
		
		app.getItems();
	}
}
