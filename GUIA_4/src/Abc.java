import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

public class Abc {
	int n = 100; 
	
	HashMap<Integer, Float> employees = new HashMap<Integer, Float>(); 
	Map<Integer, Float> linkedEmployees = new LinkedHashMap<>();

	int rutMin = 0;
	int rutMax = 0;
	
	Set<Integer> rutTemp = new HashSet<Integer>(); 
	
	public void assignRuts () {
		Random random = new Random(); 

		while (rutTemp.size() < n) {
			int number = 10000000 + random.nextInt(90000000);
			rutTemp.add(number);
		}
		
		for (int numerRut : rutTemp) { 
			employees.put(numerRut, assignSalaries()); 
        } 
	}
	
	private float assignSalaries () { 
		Random random = new Random();
		int number = random.nextInt(4001) + 1000; 
		
		return number;
	}
	
	public void showEmployees () {
		System.out.println("----------------------------");
		System.out.println("EMPLEADOS DE LA EMPRESA ABC"); 
		System.out.println("----------------------------");
		
		int i = 1;
		
		for (Integer rut: employees.keySet()) {
			float salario = employees.get(rut);
			
			System.out.println("" + i + " " + rut + ": " + salario);
			i++;
		}
	} 
	
	public void order () {
		List<Map.Entry<Integer, Float>> lista = new ArrayList<>(employees.entrySet());
		
		Collections.sort(lista, new Comparator<Map.Entry<Integer, Float>>() {
            @Override
            public int compare(Map.Entry<Integer, Float> value1, Map.Entry<Integer, Float> value2) {
                return value1.getValue().compareTo(value2.getValue());
            }
        }); 

        for (Map.Entry<Integer, Float> entry : lista) {
            linkedEmployees.put(entry.getKey(), entry.getValue()); 
        } 
	}
	
	public void showLinkedEmployees () {
		
		System.out.println("----------------------------");
		System.out.println("EMPLEADOS DE LA EMPRESA ABC"); 
		System.out.println("----------------------------"); 		
		
		int i = 1;
		
		for (Integer rut: linkedEmployees.keySet()) {
			float salario = employees.get(rut); 
			System.out.println("" + i + " " + rut + ": " + salario);
			i++;
		}
	}
	
	public void listOfTheThirtyBeneficiaries() {
		System.out.println("-----------------------------------------");
		System.out.println("EMPLEADOS DE LA EMPRESA ABC BENEFICIADOS"); 
		System.out.println("-----------------------------------------"); 	
		
		int counter = 0;
		
		for (Integer rut: linkedEmployees.keySet()) {
			if (counter == 0) {
				rutMin = rut;
			}

			
			if (counter < 30) {
				rutMax = rut;
				float salario = linkedEmployees.get(rut); 
				System.out.println("" + (counter + 1) + " " + rut + ": " + salario); 
				counter++;
			} else {
				break;
			}
		}
		
		counter = 0;
		
		System.out.println("----------------------------");
		System.out.println("DESPUES DEL BENEFICIO DEL 5%");
		System.out.println("----------------------------");
		
		for (Integer rut: linkedEmployees.keySet()) { 
			if (counter < 30) {
				employees.put(rut, (float) (linkedEmployees.get(rut) * 1.05));

				float salario = (float) (employees.get(rut)); 
				System.out.println("" + (counter + 1) + " " + rut + ": " + salario); 
				
				counter++;
			} else {
				break;
			}
		}
	}
	
	public void rutMin () {
		float salario = linkedEmployees.get(rutMin);

		System.out.println(); 
		System.out.println("------------------------------------");
		System.out.println("LA PERSONA CON LA MENOR BONIFICACION");
		System.out.println("------------------------------------");
		
		System.out.println("RUT: " + rutMin);

		System.out.println("SALARIO INICIAL: " + salario); 
		System.out.println("SALARIO FINAL: " + (salario * 1.05)); 
		
		System.out.println("Aumento del 5%: " + (salario * 0.05));
	}
	
	public void rutMax () {
		float salario = linkedEmployees.get(rutMax);

		System.out.println(); 
		System.out.println("------------------------------------");
		System.out.println("LA PERSONA CON LA MEJOR BONIFICACION");
		System.out.println("------------------------------------");
		
		System.out.println("RUT: " + rutMax);

		System.out.println("SALARIO INICIAL: " + salario); 
		System.out.println("SALARIO FINAL: " + (salario * 1.05)); 
		
		System.out.println("Aumento del 5%: " + (salario * 0.05));
	}
	
	public void findEmployeesByRut (int rut) {
		
		int counter = 0;
		int position = -1;
		
		for (Entry<Integer, Float> entry : employees.entrySet()) {
            if (entry.getKey().equals(rut)) {
                position = counter;
                break; // Detener el bucle una vez que se encuentra la clave
            }

            counter++;
        }

		if (position == -1) {
			JOptionPane.showMessageDialog(null, "No se encontro ningun empleado con dicho rut", "Error", JOptionPane.ERROR_MESSAGE); 
		} else {
			JOptionPane.showMessageDialog(null, "Se encontro el empleado con rut: " + rut + " en la posicion: " + (position + 1) + " \n salario actual: " + employees.get(rut)); 
		}
//		System.out.println(employees.get(rut));
	}
	
	public static void main(String[] args) {
		Abc prueba = new Abc();
		prueba.assignRuts(); 
		
		prueba.showEmployees();
		prueba.order(); 

		prueba.showLinkedEmployees();
		prueba.listOfTheThirtyBeneficiaries();
		prueba.rutMin();
		prueba.rutMax();
	}
}
