import java.util.Arrays;

public class ShellSort {
	private int[] array;
	
	public ShellSort(int[] array) {
		this.array = array;
	}

    public void shellSort() {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public void showArray() {
        Arrays.toString(array); 
    }

    public static void main(String[] args) { 
    	Array array = new Array(5); 
    	array.fillMatrix();

    	ShellSort shellShort = new ShellSort(array.getArray());

    	System.out.println("Arreglo original:"); 
    	shellShort.showArray();
    	
    	shellShort.shellSort();
    	
    	System.out.println("\nArreglo ordenado:");
    	shellShort.showArray();
    }
}