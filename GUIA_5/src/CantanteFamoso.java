public class CantanteFamoso {
	String nombre = "";
	String discoConMasVentas = ""; 
	int cantidadVentas = 0;
	
	public CantanteFamoso(String nombre, String discoConMasVentas, int cantidadVentas) {
		this.nombre = nombre;
		this.discoConMasVentas = discoConMasVentas;
		this.cantidadVentas = cantidadVentas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDisco() {
		return discoConMasVentas;
	}
	
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}
	
	public void setDisco(String nuevoDisco) {
		discoConMasVentas = nuevoDisco;
	}
	
	public int getVentas() {
		return cantidadVentas;
	}
	
	public void setVentas(int nuevasVentas) {
		cantidadVentas = nuevasVentas;
	}
}

