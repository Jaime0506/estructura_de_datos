import java.util.Random;

public class Insertion {

    public static void main(String[] args) {
    
        int n = 1000; 
       
        int[] arr = generateRandomArray(n); 
        long startTime = System.currentTimeMillis(); 

        insertionSort(arr);
       
        long endTime = System.currentTimeMillis();
        long elapsedTimeMillis = endTime - startTime;
        
        // System.out.println(Arrays.toString(arr)); 
        System.out.println("Time elapsed: " + elapsedTimeMillis + " ms");
    }

    
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100001); 
        }
        return arr;
    }

    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
