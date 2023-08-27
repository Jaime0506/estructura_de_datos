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
		
	}
	
	public void getTempsAllDays() {
		for (int i = 0; i < daysOfWeek.size(); i++) { 
			List<List<Double>> day = daysOfWeek.get(i);
			
			System.out.println("Temperaturas del " + listNameDays[i]);
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
	}
	
	public void setDays(int idDay) { 
		daysOfWeek.add(idDay, array[idDay]); 
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
	
	public void getPromTemp() { 
		double min = 0;
		double max = 0;
		
		System.out.println("---- Listado de temperatura promedio de cada dia ----");
		System.out.println("");
		for (int day = 0; day < daysOfWeek.size(); day++) { 
			System.out.println("" + listNameDays[day]);
			System.out.println("");

			for (int record = 0; record < daysOfWeek.get(day).size(); record++) {
				for (int temp = 0; temp < daysOfWeek.get(day).get(record).size(); temp++) {
					if (temp == 0) {
						min += daysOfWeek.get(day).get(record).get(temp);
					}
					
					if (temp == 1) { 
						max += daysOfWeek.get(day).get(record).get(temp);
					}
				}
			}
			
			System.out.println("Minima promedio: " + min/daysOfWeek.get(day).size());
			System.out.println("Maxima promedio: " + max/daysOfWeek.get(day).size());
			System.out.println("");
			
			min = 0;
			max = 0;
		} 
	}
	
	public void showDaysByMinTemp() {
		System.out.println("---- Dias cuya temperatura minima estan bajo 0 ----");
		System.out.println("");

		for (int day = 0; day < daysOfWeek.size(); day++) {
			double min = daysOfWeek.get(day).get(0).get(0);
			
			for (int tempsOfDay = 0; tempsOfDay < daysOfWeek.get(day).size(); tempsOfDay++) { 

				for (int temp = 0; temp < daysOfWeek.get(day).get(tempsOfDay).size(); temp++) {
					if (temp == 0) {
						
						if (min > daysOfWeek.get(day).get(tempsOfDay).get(temp)) {
							min = daysOfWeek.get(day).get(tempsOfDay).get(temp);
						} 
					}
				} 
			} 
			
			if (min < 0) { 
				System.out.println("" + listNameDays[day] + ": temperatura minima registrada: " + min + " C ");
			}
		}	
		System.out.println("");
	}
	
	public void showDaysByMaxTemp() {
		System.out.println("---- Dias cuya temperatura maxima esta entre 15 y 20 C ----");
		System.out.println("");

		for (int day = 0; day < daysOfWeek.size(); day++) {
			double min = daysOfWeek.get(day).get(0).get(1);
			
			for (int tempsOfDay = 0; tempsOfDay < daysOfWeek.get(day).size(); tempsOfDay++) { 

				for (int temp = 0; temp < daysOfWeek.get(day).get(tempsOfDay).size(); temp++) {
					if (temp == 1) {
						
						if (min > daysOfWeek.get(day).get(tempsOfDay).get(temp)) {
							min = daysOfWeek.get(day).get(tempsOfDay).get(temp);
						} 
					}
				} 
			} 
			
			if (min >= 15 && min <= 20) { 
				System.out.println("" + listNameDays[day] + ": temperatura registrada: " + min + " C ");
			}
		}	
		System.out.println("");
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimaApi app = new ClimaApi();
		
		app.setDays(0);
		app.setDays(1);
		app.setDays(2);
		
		app.setTempsByIdOfDay(0, 20, 30);
		app.setTempsByIdOfDay(0, -25, 50);
		app.setTempsByIdOfDay(0, 15, 20);
		app.setTempsByIdOfDay(0, -15, 20);
		
		app.setTempsByIdOfDay(1, 30, 35);
		app.setTempsByIdOfDay(1, -11, 30);
		app.setTempsByIdOfDay(1, 30, 35);
		app.setTempsByIdOfDay(1, -16, 24);

		app.setTempsByIdOfDay(2, -20, 10); 
		app.setTempsByIdOfDay(2, 15, 30); 
		app.setTempsByIdOfDay(2, -5, 10); 
		app.setTempsByIdOfDay(2, -4, 14);

//		app.getTempsByIdOfDays(0); 
//		Double[] tempMinAndMax = app.getPromTempByIdOfDay(0);
//		System.out.println("Temperatura Minima Prom: " + tempMinAndMax[0]);
//		System.out.println("Temperatura Maxima Prom: " + tempMinAndMax[1]); 

//		app.getTempsByIdOfDays(1);
//		app.getTempsByIdOfDays(2);
		app.getTempsAllDays();
		
		app.showDaysByMinTemp();
		app.showDaysByMaxTemp();
	} 
}
