import java.util.Arrays;

public class QuickShort {

	private int array[];
	
	public QuickShort(int[] array) {
		this.array = array;
	}
	
	public void quickSort(int[] arr, int init, int end) {
        if (init < end) { 
            int indicePivote = partition(arr, init, end); 

            quickSort(arr, init, indicePivote - 1);
            quickSort(arr, indicePivote + 1, end);
        } 
    }

    public int partition(int[] arr, int inicio, int fin) { 
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
        	
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } 
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp; 

        return i + 1;
    }
    
    public void showArray() {
    	System.out.println(Arrays.toString(array));
    } 
//    public static void main(String[] args) {
//    	Array array = new Array(5);
//    	
//    	array.fillMatrix();
//    	
//		QuickShort quickShort = new QuickShort(array.getArray());
//		quickShort.quickSort(array.getArray(), 0, array.getArray().length - 1);
//		quickShort.showArray();
//	}
}
