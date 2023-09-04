import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Array array = new Array(10000000);
		array.fillMatrix();
		
		int[] arrayPrueba = array.getArray();
		
//		 QUICKSORT
//		System.out.println("ARRAY INICIAL"); 
//
//		System.out.println(Arrays.toString(arrayPrueba));
//
//		int timeInit = (int) System.currentTimeMillis();
//		
//		QuickShort arrayResult = new QuickShort(arrayPrueba); 
//		arrayResult.quickSort(arrayPrueba, 0, arrayPrueba.length - 1);
//		
//		int timeFinish = (int) System.currentTimeMillis() - timeInit;
//		
////		System.out.println("");
////		System.out.println("ARRAY ORGANIZADO");
////		arrayResult.showArray();
//		
//		System.out.println("");
//		System.out.println("TIEMPO UTILIZADO " + timeFinish + " MS");
		
		//SHELLSORT
		
		System.out.println("ARRAY INICIAL");
		System.out.println(Arrays.toString(arrayPrueba));

		int timeInit = (int) System.currentTimeMillis();
		ShellSort arrayResult = new ShellSort(arrayPrueba);
		
		arrayResult.shellSort();
		
		int timeFinish = (int) System.currentTimeMillis() - timeInit;

		System.out.println("");
		System.out.println("ARRAY ORGANIZADO");
		array.showMatrix();
		System.out.println("");
		
		System.out.println("TIEMPO UTILIZADO " + timeFinish + " MS");
	}
}
