import java.util.Arrays;
import java.util.Random;

public class Bubble {

    public static void main(String[] args) {
        
//        int n = 1000; // You can change this to the desired array size.
//        int[] arr = generateRandomArray(n);
        int[] arr = {19, 1, 9, 7, 3, 10, 13, 15, 8, 12};
        long startTime = System.currentTimeMillis();

        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Time elapsed: " + elapsedTime + " ms");
    }

    // Function to generate an array of random integers.
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000); // Generates random integers between 0 and 99.999
        }
        return arr;
    }

    // Function to perform Bubble Sort on an array.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
        	System.out.println("pasada " + (i + 1));
        	
        	if (i == 2) {
        		System.out.println(Arrays.toString(arr));
        	}
        	
        	if (i == 3) {
        		System.out.println(Arrays.toString(arr));
        	}

            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Function to print an array.
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
