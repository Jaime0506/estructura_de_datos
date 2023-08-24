import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//b)	Una estación climática proporciona N pares de temperaturas diarias (máxima, mínima) junto al nombre del día respectivo (no es posible que alguna o ambas temperaturas sea menor a -40 grados y mayor a 40 grados).  Se pide determinar:
//•	Días y temperatura, cuyas temperaturas máximas estén entre 15 y 20 grados, 
//•	Días y temperatura, cuyas temperaturas mínimas estén por debajo de 0 grados
//•	Calcular las medias máxima y mínima de temperaturas, 
//•	mostrar finalmente el listado de temperaturas con su día respectivo.

// El usuario ingresa las temperaturas manualmente a travez de la interfaz, seleccionando el dia respectivo. 

public class ClimaApi {
	// Lunes, Martes, Miercoles, Jueves, Vieres, Sabado Domingo 
	public List<List<List<Double>>> daysOfWeek = new ArrayList<>(); 
	public String listNameDays[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
	// temp of day
	public List<List<Double>> tempMonday = new ArrayList<>(); 
	public List<List<Double>> tempTuesday = new ArrayList<>();
	public List<List<Double>> tempWednesday = new ArrayList<>();
	public List<List<Double>> tempThursday = new ArrayList<>();
	public List<List<Double>> tempFriday = new ArrayList<>();
	public List<List<Double>> tempSaturday = new ArrayList<>();
	public List<List<Double>> tempSunday = new ArrayList<>();
	
	@SuppressWarnings("rawtypes")
	public List array[] = {tempMonday, tempTuesday, tempWednesday, tempThursday, tempFriday, tempSaturday, tempSunday};
	
	public ClimaApi() {
		setDays();
	}
	
	private void setDays() {
		int numberOfDay = 7;
		for (int index = 0; index < numberOfDay; index++) { 
			daysOfWeek.add(index, array[index]);
		}
	}
	
	public void setTempsByIdOfDay(int idDay, double minTemp, double maxTemp) {
		List<Double> temp = new ArrayList<>(Arrays.asList(minTemp, maxTemp));
		daysOfWeek.get(idDay).add(temp);
	}
	
	public void getTempsByIdOfDays(int idDay) {
		List<List<Double>> day = daysOfWeek.get(idDay);
		
		System.out.println("Temperaturas del " + listNameDays[idDay]);
		for (Iterator iterator = day.iterator(); iterator.hasNext();) {
			List<Double> tempOfDay = (List<Double>) iterator.next(); 
			System.out.print("| ");

			for (Iterator iterator2 = tempOfDay.iterator(); iterator2.hasNext();) {
				Double temps = (Double) iterator2.next();
				System.out.print(temps + " C | ");
			} 
			System.out.println("");
		} 
		System.out.println("");
	}
	
	public Double[] getPromTempByIdOfDay(int idDay) {
		Double tempProm[] = new Double[2];
		List<List<Double>> day = daysOfWeek.get(idDay);
		
		double min = 0;
		double max = 0;
		
		for (int record = 0; record < day.size(); record++) {
			for (int temp = 0; temp < day.get(record).size(); temp++) {
				if (temp == 0) {
					min += day.get(record).get(temp);
				}
				
				if (temp == 1) {
					max += day.get(record).get(temp);
				}
			}
		}
		
		min = min / day.size();
		max = max / day.size();
		
		tempProm[0] = min;
		tempProm[1] = max;
		
		return tempProm;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimaApi app = new ClimaApi();
		
		app.setTempsByIdOfDay(0, 20, 30);
		app.setTempsByIdOfDay(0, -25, 50);
		app.setTempsByIdOfDay(0, 15, 20);
		app.setTempsByIdOfDay(0, -15, 20);

		app.getTempsByIdOfDays(0); 
		
		Double[] tempMinAndMax = app.getPromTempByIdOfDay(0);
		System.out.println("Temperatura Minima Prom: " + tempMinAndMax[0]);
		System.out.println("Temperatura Maxima Prom: " + tempMinAndMax[1]); 
	} 
}