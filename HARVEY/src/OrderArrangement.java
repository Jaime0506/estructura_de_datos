import java.util.ArrayList;

public class OrderArrangement {
	
	public void burbujaSort(ArrayList<Integer> lista) { 
        int n = lista.size();
        boolean intercambio;
        
        do {
            intercambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (lista.get(i) > lista.get(i + 1)) { 
                    int temp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, temp);
                    intercambio = true;
                }
            }
        } while (intercambio);
    }

	
	public static void main(String[] args) {
		OrderArrangement app = new OrderArrangement();
		
		ArrayList<Integer> array = new ArrayList<>(); 

		array.add(2);
		array.add(1);
		array.add(9);
		array.add(5);
		array.add(6);
		array.add(8);
		
		System.out.println("Lista inicial");
		for (Integer integer : array) {
			System.out.print(integer + " ");
		}		
		
		app.burbujaSort(array);
		System.out.println("");
		
		System.out.println("Lista ordenada");
		for (Integer integer : array) {
			System.out.print(integer + " ");
		}

	}
}
